package com.company.game_ending_strategies;

import com.company.chess_board.Board;
import com.company.chess_board.Color;
import com.company.chess_board.Move;
import com.company.chess_board.pieces.King;

public class CheckMateStrategy implements GameOverStrategies {

    @Override
    public boolean ifGameEnded(Board board, Move move) {
        Color nextTurn = move.getPlayedBy().getColor().equals(Color.WHITE) ? Color.BLACK : Color.WHITE;

        // Check for no active king for the other team
        return board.getPieces().get(nextTurn).stream()
                .anyMatch(piece -> piece instanceof King && piece.getCellValue() == null);
    }
}
