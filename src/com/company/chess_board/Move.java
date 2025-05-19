package com.company.chess_board;

import com.company.chess_board.pieces.Piece;
import com.company.player.Player;

public class Move {

    private final Piece piece;
    private final Cell targetCell;
    private final Player playedBy;

    public Move(Piece piece, Cell targetCell, Player playedBy) {
        this.targetCell = targetCell;
        this.piece = piece;
        this.playedBy = playedBy;
    }

    public Cell getTargetCell() {
        return targetCell;
    }

    public Piece getPiece() {
        return piece;
    }

    public Player getPlayedBy() {
        return playedBy;
    }

}
