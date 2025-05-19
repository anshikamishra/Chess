package com.company.chess_board.pieces;

import com.company.chess_board.*;
import com.company.utils.ChessPieceBlueprint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PieceOperator {

    public static Map<Color, List<Piece>> initializePieces(Board board) {
        return setupFromBlueprint(board);
    }

    private static Map<Color, List<Piece>> setupFromBlueprint(Board board) {
        List<Piece> whitePieces = new ArrayList<>();
        List<Piece> blackPieces = new ArrayList<>();

        for (String blueprint : ChessPieceBlueprint.PIECES_BLUEPRINT) {
            String[] parts = blueprint.split(",");
            Color color = parts[0].trim().equals("WHITE") ? Color.WHITE : Color.BLACK;
            String pieceType = parts[1].trim();
            int row = Integer.parseInt(parts[2].trim());
            int col = Integer.parseInt(parts[3].trim());

            Piece piece = null;
            Coordinates coord = new Coordinates(row, col);

            if (pieceType.equals("ROOK")) {
                piece = new Rook(color, coord);
            } else if (pieceType.equals("KNIGHT")) {
                piece = new Knight(color, coord);
            } else if (pieceType.equals("BISHOP")) {
                piece = new Bishop(color, coord);
            } else if (pieceType.equals("QUEEN")) {
                piece = new Queen(color, coord);
            } else if (pieceType.equals("KING")) {
                piece = new King(color, coord);
            } else if (pieceType.equals("PAWN")) {
                piece = new Pawn(color, coord);
            }

            Cell cell = BoardOperator.getCellByCoordinates(board, coord);
            if (cell == null) {
                throw new RuntimeException("No cell found for coordinates " + coord);
            }
            associatePieceAndCell(cell, piece);

            if (color.equals(Color.WHITE)) {
                whitePieces.add(piece);
            } else {
                blackPieces.add(piece);
            }
        }

        Map<Color, List<Piece>> chessPieces = new HashMap<>();
        chessPieces.put(Color.WHITE, whitePieces);
        chessPieces.put(Color.BLACK, blackPieces);
        return chessPieces;
    }

    public static void associatePieceAndCell(Cell cell, Piece piece) {
        cell.setPiece(piece);
        piece.setCellValue(cell);
    }

    public static void dissociatePieceAndCell(Piece piece) {
        Cell cell = piece.getCellValue();
        cell.setPiece(null);
        piece.setCellValue(null);
    }

    public static void resetPiecePosition(Board board) {
        List<Piece> combined = Stream.concat(
                        board.getPieces().get(Color.WHITE).stream(),
                        board.getPieces().get(Color.BLACK).stream())
                .collect(Collectors.toList());

        combined.forEach(piece -> {
            Coordinates coordinates = piece.getDefaultCoordinates();
            Cell cell = BoardOperator.getCellByCoordinates(board, coordinates);

            if (cell == null) {
                throw new RuntimeException("No cell found for coordinates " + coordinates);
            }
            dissociatePieceAndCell(piece);
            associatePieceAndCell(cell, piece);
        });
    }
}
