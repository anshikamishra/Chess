package com.company.game_engine;

import com.company.chess_board.Cell;
import com.company.chess_board.pieces.Piece;
import com.company.player.Player;

public class ActionValidator {

    // Start cell should be valid (row=[1,8], col=[1,8])
    public static boolean isLegalCell(Cell fromCell) {
        return fromCell != null;
    }

    // Start cell should be non-empty
    public static boolean isCellEmpty(Cell fromCell, Player currentPlayer) {
        return fromCell.getPiece() != null;
    }

    // Piece should belong to the player
    public static boolean isPlayersPiece(Cell fromCell, Player currentPlayer) {
        Piece piece = fromCell.getPiece();
        return piece != null && piece.getPieceColor() == currentPlayer.getColor();
    }


}
