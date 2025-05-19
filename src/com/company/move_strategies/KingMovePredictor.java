package com.company.move_strategies;

import com.company.chess_board.Board;
import com.company.chess_board.BoardOperator;
import com.company.chess_board.Cell;
import com.company.chess_board.Coordinates;
import com.company.chess_board.pieces.Piece;
import com.company.utils.Helper;

import java.util.ArrayList;
import java.util.List;

public class KingMovePredictor implements MovePredictor {

    @Override
    public List<Cell> getPossibleTargetCells(Piece piece, Board board) {

        List<Cell> possiblePositions = new ArrayList<>();
        Cell fromCell = piece.getCellValue();
        int rowNumber = fromCell.getCoordinates().getRowNumber();
        int colNumber = fromCell.getCoordinates().getColNumber();

        // Single movement up
        Cell toCell1 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber + 1, colNumber));
        if (toCell1 != null && (Helper.isEmptyCell(toCell1) || Helper.areCellsFromRivalTeam(fromCell, toCell1))) {
            possiblePositions.add(toCell1);
        }

        // Single movement  down
        Cell toCell2 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber - 1, colNumber));
        if (toCell2 != null && (Helper.isEmptyCell(toCell2) || Helper.areCellsFromRivalTeam(fromCell, toCell2))) {
            possiblePositions.add(toCell2);
        }

        // Single movement  right
        Cell toCell3 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber, colNumber + 1));
        if (toCell3 != null && (Helper.isEmptyCell(toCell3) || Helper.areCellsFromRivalTeam(fromCell, toCell3))) {
            possiblePositions.add(toCell3);
        }

        // Single movement  left
        Cell toCell4 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber, colNumber - 1));
        if (toCell4 != null && (Helper.isEmptyCell(toCell4) || Helper.areCellsFromRivalTeam(fromCell, toCell4))) {
            possiblePositions.add(toCell4);
        }

        // Single movement north-east
        Cell toCell5 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber + 1, colNumber + 1));
        if (toCell5 != null && (Helper.isEmptyCell(toCell5) || Helper.areCellsFromRivalTeam(fromCell, toCell5))) {
            possiblePositions.add(toCell5);
        }

        // Single movement south-west
        Cell toCell6 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber - 1, colNumber - 1));
        if (toCell6 != null && (Helper.isEmptyCell(toCell6) || Helper.areCellsFromRivalTeam(fromCell, toCell6))) {
            possiblePositions.add(toCell6);
        }

        // Single movement north-west
        Cell toCell7 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber + 1, colNumber - 1));
        if (toCell7 != null && (Helper.isEmptyCell(toCell7) || Helper.areCellsFromRivalTeam(fromCell, toCell7))) {
            possiblePositions.add(toCell7);
        }

        // Single movement south-east
        Cell toCell8 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber - 1, colNumber + 1));
        if (toCell8 != null && (Helper.isEmptyCell(toCell8) || Helper.areCellsFromRivalTeam(fromCell, toCell8))) {
            possiblePositions.add(toCell8);
        }

        return possiblePositions;
    }

}
