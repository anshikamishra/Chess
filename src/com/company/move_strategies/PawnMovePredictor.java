package com.company.move_strategies;

import com.company.chess_board.*;
import com.company.chess_board.pieces.Piece;
import com.company.utils.Helper;

import java.util.ArrayList;
import java.util.List;

public class PawnMovePredictor implements MovePredictor {

    @Override
    public List<Cell> getPossibleTargetCells(Piece piece, Board board) {

        Cell fromCell = piece.getCellValue();
        int rowNumber = fromCell.getCoordinates().getRowNumber();
        int colNumber = fromCell.getCoordinates().getColNumber();

        List<Cell> possiblePositions = new ArrayList<>();

        if (fromCell.getPiece().getPieceColor().equals(Color.BLACK)) {

            // Single movement up
            Cell toCell1 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber + 1, colNumber));
            if (toCell1 != null && Helper.isEmptyCell(toCell1)) {
                possiblePositions.add(toCell1);
            }

            // Single movement north-west
            Cell toCell2 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber + 1, colNumber - 1));
            if (toCell2 != null && Helper.isOccupied(toCell2) && Helper.areCellsFromRivalTeam(fromCell, toCell2)) {
                possiblePositions.add(toCell2);
            }

            // Single movement north-east
            Cell toCell3 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber + 1, colNumber + 1));
            if (toCell3 != null && Helper.isOccupied(toCell3) && Helper.areCellsFromRivalTeam(fromCell, toCell3)) {
                possiblePositions.add(toCell3);
            }
        } else if (fromCell.getPiece().getPieceColor().equals(Color.WHITE)) {

            // Single movement up
            Cell toCell1 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber - 1, colNumber));
            if (toCell1 != null && Helper.isEmptyCell(toCell1)) {
                possiblePositions.add(toCell1);
            }

            // Single movement north-west
            Cell toCell2 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber - 1, colNumber - 1));
            if (toCell2 != null && Helper.isOccupied(toCell2) && Helper.areCellsFromRivalTeam(fromCell, toCell2)) {
                possiblePositions.add(toCell2);
            }

            // Single movement north-east
            Cell toCell3 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber - 1, colNumber + 1));
            if (toCell3 != null && Helper.isOccupied(toCell3) && Helper.areCellsFromRivalTeam(fromCell, toCell3)) {
                possiblePositions.add(toCell3);
            }
        }

        return possiblePositions;
    }
}
