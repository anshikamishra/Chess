package com.company.move_strategies;

import com.company.chess_board.Board;
import com.company.chess_board.Cell;
import com.company.chess_board.pieces.Piece;

import java.util.List;

public interface MovePredictor {

    List<Cell> getPossibleTargetCells(Piece piece, Board board);
}
