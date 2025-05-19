package com.company.utils;

import java.util.ArrayList;
import java.util.List;

public class ChessPieceBlueprint {

    public final static List<String> PIECES_BLUEPRINT = new ArrayList<>();

    static {
        PIECES_BLUEPRINT.add("WHITE, ROOK, 8, 1");
        PIECES_BLUEPRINT.add("WHITE, KNIGHT, 8, 2");
        PIECES_BLUEPRINT.add("WHITE, BISHOP, 8, 3");
        PIECES_BLUEPRINT.add("WHITE, QUEEN, 8, 4");
        PIECES_BLUEPRINT.add("WHITE, KING, 8, 5");
        PIECES_BLUEPRINT.add("WHITE, BISHOP, 8, 6");
        PIECES_BLUEPRINT.add("WHITE, KNIGHT, 8, 7");
        PIECES_BLUEPRINT.add("WHITE, ROOK, 8, 8");

        PIECES_BLUEPRINT.add("WHITE, PAWN, 7, 1");
        PIECES_BLUEPRINT.add("WHITE, PAWN, 7, 2");
        PIECES_BLUEPRINT.add("WHITE, PAWN, 7, 3");
        PIECES_BLUEPRINT.add("WHITE, PAWN, 7, 4");
        PIECES_BLUEPRINT.add("WHITE, PAWN, 7, 5");
        PIECES_BLUEPRINT.add("WHITE, PAWN, 7, 6");
        PIECES_BLUEPRINT.add("WHITE, PAWN, 7, 7");
        PIECES_BLUEPRINT.add("WHITE, PAWN, 7, 8");

        PIECES_BLUEPRINT.add("BLACK, ROOK, 1, 1");
        PIECES_BLUEPRINT.add("BLACK, KNIGHT, 1, 2");
        PIECES_BLUEPRINT.add("BLACK, BISHOP, 1, 3");
        PIECES_BLUEPRINT.add("BLACK, QUEEN, 1, 4");
        PIECES_BLUEPRINT.add("BLACK, KING, 1, 5");
        PIECES_BLUEPRINT.add("BLACK, BISHOP, 1, 6");
        PIECES_BLUEPRINT.add("BLACK, KNIGHT, 1, 7");
        PIECES_BLUEPRINT.add("BLACK, ROOK, 1, 8");

        PIECES_BLUEPRINT.add("BLACK, PAWN, 2, 1");
        PIECES_BLUEPRINT.add("BLACK, PAWN, 2, 2");
        PIECES_BLUEPRINT.add("BLACK, PAWN, 2, 3");
        PIECES_BLUEPRINT.add("BLACK, PAWN, 2, 4");
        PIECES_BLUEPRINT.add("BLACK, PAWN, 2, 5");
        PIECES_BLUEPRINT.add("BLACK, PAWN, 2, 6");
        PIECES_BLUEPRINT.add("BLACK, PAWN, 2, 7");
        PIECES_BLUEPRINT.add("BLACK, PAWN, 2, 8");
    }
}
