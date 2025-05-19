package com.company.chess_board;

public class Coordinates {

    private int rowNumber;
    private int colNumber;

    public Coordinates(int rowNumber, int colNumber) {
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColNumber() {
        return colNumber;
    }

    @Override
    public String toString() {
        return "{" + rowNumber + "," + colNumber + "}";
    }
}
