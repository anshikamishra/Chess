package com.company.chess_board;

import com.company.chess_board.pieces.Piece;
import com.company.chess_board.pieces.PieceOperator;
import com.company.utils.Helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {

    private final Map<String, Cell> cells;
    private final Map<Color, List<Piece>> pieces;

    Board() {
        this.cells = initCells();
        this.pieces = PieceOperator.initializePieces(this);
    }

    public Map<String, Cell> getCells() {
        return cells;
    }

    public Map<Color, List<Piece>> getPieces() {
        return pieces;
    }

    public void clearCells() {
        cells.forEach((key, cell) -> cell.clearCell());
    }

    private Map<String, Cell> initCells() {
        Map<String, Cell> cells = new HashMap<>();
        for (int row = Cell.ROW_START; row <= Cell.ROW_END; row++) {
            for (int col = Cell.COL_START; col <= Cell.COL_END; col++) {
                cells.put(Helper.getCellKey(new Coordinates(row, col)), new Cell(new Coordinates(row, col)));
            }
        }
        return cells;
    }
}
