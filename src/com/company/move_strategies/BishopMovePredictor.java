package com.company.move_strategies;

import com.company.chess_board.Board;
import com.company.chess_board.BoardOperator;
import com.company.chess_board.Cell;
import com.company.chess_board.Coordinates;
import com.company.chess_board.pieces.Piece;
import com.company.utils.Helper;

import java.util.ArrayList;
import java.util.List;

public class BishopMovePredictor implements MovePredictor {

    @Override
    public List<Cell> getPossibleTargetCells(Piece piece, Board board) {

        List<Cell> possiblePositions = new ArrayList<>();
        Cell fromCell = piece.getCellValue();
        int rowNumber = fromCell.getCoordinates().getRowNumber();
        int colNumber = fromCell.getCoordinates().getColNumber();

        // Movement on the North-East diagonal
        for (int newRowNum = rowNumber, newColNum = colNumber; newRowNum <= Cell.ROW_END && newColNum <= Cell.COL_END; newRowNum++, newColNum++) {
            Cell toCell = BoardOperator.getCellByCoordinates(board, new Coordinates(newRowNum, newColNum));

            if (Helper.areSameCells(fromCell, toCell)) {
                continue;
            }

            possiblePositions.add(toCell);

            // Keep moving until an occupied cell is met
            if (Helper.isOccupied(toCell)) {

                // Remove the cell from possible targets if occupied by a piece of same team
                if (!Helper.isEmptyCell(toCell) && Helper.areCellsFromSameTeam(fromCell, toCell)) {
                    possiblePositions.remove(possiblePositions.size() - 1);
                }

                break;
            }
        }

        // Movement on the North-West diagonal
        for (int newRowNum = rowNumber, newColNum = colNumber; newRowNum <= Cell.ROW_END && newColNum >= Cell.COL_START; newRowNum++, newColNum--) {
            Cell toCell = BoardOperator.getCellByCoordinates(board, new Coordinates(newRowNum, newColNum));

            if (Helper.areSameCells(fromCell, toCell)) {
                continue;
            }

            possiblePositions.add(toCell);

            // Keep moving until an occupied cell is met
            if (Helper.isOccupied(toCell)) {

                // Remove the cell from possible targets if occupied by a piece of same team
                if (!Helper.isEmptyCell(toCell) && Helper.areCellsFromSameTeam(fromCell, toCell)) {
                    possiblePositions.remove(possiblePositions.size() - 1);
                }

                break;
            }
        }

        // Movement on the South-East diagonal
        for (int newRowNum = rowNumber, newColNum = colNumber; newRowNum >= Cell.ROW_START && newColNum <= Cell.COL_END; newRowNum--, newColNum++) {
            Cell toCell = BoardOperator.getCellByCoordinates(board, new Coordinates(newRowNum, newColNum));

            if (Helper.areSameCells(fromCell, toCell)) {
                continue;
            }

            possiblePositions.add(toCell);

            // Keep moving until an occupied cell is met
            if (Helper.isOccupied(toCell)) {

                // Remove the cell from possible targets if occupied by a piece of same team
                if (!Helper.isEmptyCell(toCell) && Helper.areCellsFromSameTeam(fromCell, toCell)) {
                    possiblePositions.remove(possiblePositions.size() - 1);
                }

                break;
            }
        }

        // Movement on the South-West diagonal
        for (int newRowNum = rowNumber, newColNum = colNumber; newRowNum >= Cell.ROW_START && newColNum >= Cell.COL_START; newRowNum--, newColNum--) {
            Cell toCell = BoardOperator.getCellByCoordinates(board, new Coordinates(newRowNum, newColNum));

            if (Helper.areSameCells(fromCell, toCell)) {
                continue;
            }

            possiblePositions.add(toCell);

            // Keep moving until an occupied cell is met
            if (Helper.isOccupied(toCell)) {

                // Remove the cell from possible targets if occupied by a piece of same team
                if (!Helper.isEmptyCell(toCell) && Helper.areCellsFromSameTeam(fromCell, toCell)) {
                    possiblePositions.remove(possiblePositions.size() - 1);
                }

                break;
            }
        }

        return possiblePositions;
    }

}
