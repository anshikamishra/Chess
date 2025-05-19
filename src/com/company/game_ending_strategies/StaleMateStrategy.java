package com.company.game_ending_strategies;

import com.company.chess_board.Board;
import com.company.chess_board.Color;
import com.company.chess_board.Move;
import com.company.move_strategies.MovePredictorRegistry;

public class StaleMateStrategy implements GameOverStrategies {

    @Override
    public boolean ifGameEnded(Board board, Move move) {
        Color nextTurn = move.getPlayedBy().getColor().equals(Color.WHITE) ? Color.BLACK : Color.WHITE;

        int possibleMoveCount =
                board.getPieces().get(nextTurn).stream()
                        .filter(piece -> piece.getCellValue() != null)
                        .mapToInt(piece ->
                                MovePredictorRegistry
                                        .getPredictor(piece)
                                        .getPossibleTargetCells(piece, board).size())
                        .sum();

        return possibleMoveCount == 0;
    }
}
