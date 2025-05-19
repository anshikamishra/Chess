package com.company.chess_board.pieces;

import com.company.chess_board.Cell;
import com.company.chess_board.Color;
import com.company.chess_board.Coordinates;

public interface Piece {

    String getPieceSymbol();

    Color getPieceColor();

    Cell getCellValue();

    Cell setCellValue(Cell cell);

    Coordinates getDefaultCoordinates();    // To reset the piece position
}
