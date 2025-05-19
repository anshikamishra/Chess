package com.company.chess_board;

import com.company.chess_board.pieces.PieceOperator;
import com.company.utils.Helper;

public class BoardOperator {

    public static Board initializeBoard() {
        return new Board();
    }

    // Function empties cells, resets pieces.
    public static void resetBoard(Board board) {
        board.clearCells();
        PieceOperator.resetPiecePosition(board);
    }

    public static Cell getCellByCoordinates(Board board, Coordinates coord) {
        if (coord.getRowNumber() < Cell.ROW_START || coord.getRowNumber() > Cell.ROW_END
                || coord.getColNumber() < Cell.COL_START || coord.getColNumber() > Cell.COL_END) {
            return null;
        }
        return board.getCells().get(Helper.getCellKey(coord));
    }

    public static void updateCellAndPieceAssociation(Board board, Move move) {
        // Dissociate moved piece & it's cell
        PieceOperator.dissociatePieceAndCell(move.getPiece());

        // Dissociate target cell & it's piece (if target cell is not-empty)
        if (move.getTargetCell().getPiece() != null) {
            PieceOperator.dissociatePieceAndCell(move.getTargetCell().getPiece());
        }

        // Associate moved piece and target cell
        PieceOperator.associatePieceAndCell(move.getTargetCell(), move.getPiece());
    }
}
