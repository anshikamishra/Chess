package com.company.game_ending_strategies;

import com.company.chess_board.Board;
import com.company.chess_board.Move;

public interface GameOverStrategies {

    boolean ifGameEnded(Board board, Move lastMove);
}
