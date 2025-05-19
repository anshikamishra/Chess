package com.company.move_strategies;

import com.company.chess_board.Board;
import com.company.chess_board.BoardOperator;
import com.company.chess_board.Cell;
import com.company.chess_board.Coordinates;
import com.company.chess_board.pieces.Piece;
import com.company.utils.Helper;

import java.util.ArrayList;
import java.util.List;

public class RookMovePredictor implements MovePredictor {

    @Override
    public List<Cell> getPossibleTargetCells(Piece piece, Board board) {

        Cell fromCell = piece.getCellValue();
        int rowNumber = fromCell.getCoordinates().getRowNumber();
        int colNumber = fromCell.getCoordinates().getColNumber();

        List<Cell> possiblePositions = new ArrayList<>();

        // Movement right
        for (int newColNum = colNumber; newColNum <= Cell.COL_END; newColNum++) {
            Cell toCell = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber, newColNum));

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

        // Movement left
        for (int newColNum = colNumber; newColNum >= Cell.COL_START; newColNum--) {
            Cell toCell = BoardOperator.getCellByCoordinates(board, new Coordinates(rowNumber, newColNum));

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

        // Movement up
        for (int newRowNum = rowNumber; newRowNum <= Cell.ROW_END; newRowNum++) {
            Cell toCell = BoardOperator.getCellByCoordinates(board, new Coordinates(newRowNum, colNumber));

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

        // Movement down
        for (int newRowNum = rowNumber; newRowNum >= Cell.ROW_START; newRowNum--) {
            Cell toCell = BoardOperator.getCellByCoordinates(board, new Coordinates(newRowNum, colNumber));

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
