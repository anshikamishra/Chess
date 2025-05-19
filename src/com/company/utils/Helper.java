package com.company.utils;

import com.company.chess_board.Cell;
import com.company.chess_board.Coordinates;
import com.company.chess_board.pieces.Piece;

public class Helper {

    public static String getCellKey(Coordinates coordinates) {
        return String.valueOf(coordinates.getRowNumber()) + '-' + coordinates.getColNumber();
    }

    public static boolean areCellsFromSameTeam(Piece piece1, Piece piece2) {
        return piece1.getPieceColor().equals(piece2.getPieceColor());
    }

    public static boolean areCellsFromSameTeam(Cell cell1, Cell cell2) {
        return cell1.getPiece().getPieceColor().equals(cell2.getPiece().getPieceColor());
    }

    public static boolean areCellsFromRivalTeam(Cell cell1, Cell cell2) {
        return !areCellsFromSameTeam(cell1, cell2);
    }

    public static boolean isOccupied(Cell cell) {
        return !isEmptyCell(cell);
    }

    public static boolean isEmptyCell(Cell cell) {
        return cell.getPiece() == null;
    }

    public static boolean areSameCells(Cell cell1, Cell cell2) {
        return cell1.equals(cell2);
    }
}
