package com.company.chess_board;


import com.company.chess_board.pieces.Piece;

public class Cell {

    private final Coordinates coordinates;
    private Piece piece;
    public static final int ROW_START = 1;
    public static final int ROW_END = 8;
    public static final int COL_START = 1;
    public static final int COL_END = 8;

    Cell(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void clearCell() {
        this.piece = null;
    }

}
