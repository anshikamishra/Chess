package com.company.move_strategies;

import com.company.chess_board.Board;
import com.company.chess_board.BoardOperator;
import com.company.chess_board.Cell;
import com.company.chess_board.Coordinates;
import com.company.chess_board.pieces.Piece;
import com.company.utils.Helper;

import java.util.ArrayList;
import java.util.List;

public class KnightMovePredictor implements MovePredictor {

    @Override
    public List<Cell> getPossibleTargetCells(Piece piece, Board board) {

        List<Cell> possiblePositions = new ArrayList<>();
        Cell fromCell = piece.getCellValue();
        int rowNumber = fromCell.getCoordinates().getRowNumber();
        int colNumber = fromCell.getCoordinates().getColNumber();

        Cell toCell1 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber + 2, colNumber + 1));
        if (toCell1 != null && (Helper.isEmptyCell(toCell1) || Helper.areCellsFromRivalTeam(fromCell, toCell1))) {
            possiblePositions.add(toCell1);
        }

        Cell toCell2 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber + 2, colNumber - 1));
        if (toCell2 != null && (Helper.isEmptyCell(toCell2) || Helper.areCellsFromRivalTeam(fromCell, toCell2))) {
            possiblePositions.add(toCell2);
        }

        Cell toCell3 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber - 2, colNumber + 1));
        if (toCell3 != null && (Helper.isEmptyCell(toCell3) || Helper.areCellsFromRivalTeam(fromCell, toCell3))) {
            possiblePositions.add(toCell3);
        }

        Cell toCell4 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber - 2, colNumber - 1));
        if (toCell4 != null && (Helper.isEmptyCell(toCell4) || Helper.areCellsFromRivalTeam(fromCell, toCell4))) {
            possiblePositions.add(toCell4);
        }

        Cell toCell5 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber + 1, colNumber + 2));
        if (toCell5 != null && (Helper.isEmptyCell(toCell5) || Helper.areCellsFromRivalTeam(fromCell, toCell5))) {
            possiblePositions.add(toCell5);
        }

        Cell toCell6 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber - 1, colNumber + 2));
        if (toCell6 != null && (Helper.isEmptyCell(toCell6) || Helper.areCellsFromRivalTeam(fromCell, toCell6))) {
            possiblePositions.add(toCell6);
        }

        Cell toCell7 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber + 1, colNumber - 2));
        if (toCell7 != null && (Helper.isEmptyCell(toCell7) || Helper.areCellsFromRivalTeam(fromCell, toCell7))) {
            possiblePositions.add(toCell7);
        }

        Cell toCell8 = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber - 1, colNumber - 2));
        if (toCell8 != null && (Helper.isEmptyCell(toCell8) || Helper.areCellsFromRivalTeam(fromCell, toCell8))) {
            possiblePositions.add(toCell8);
        }

        return possiblePositions;
    }
}
