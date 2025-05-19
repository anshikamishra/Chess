package com.company.chess_board.pieces;

import com.company.chess_board.Cell;
import com.company.chess_board.Color;
import com.company.chess_board.Coordinates;

public class Pawn implements Piece {

    private final Color color;
    private final Coordinates defaultCoordinates;
    private Cell cell;

    Pawn(Color color, Coordinates defaultCoordinates) {
        this.color = color;
        this.defaultCoordinates = defaultCoordinates;
    }

    @Override
    public Coordinates getDefaultCoordinates() {
        return defaultCoordinates;
    }

    @Override
    public String getPieceSymbol() {
        return this.getPieceColor().name().charAt(0) + "p";
    }

    @Override
    public Color getPieceColor() {
        return this.color;
    }

    @Override
    public Cell getCellValue() {
        return this.cell;
    }

    @Override
    public Cell setCellValue(Cell cell) {
        this.cell = cell;
        return null;
    }
}
