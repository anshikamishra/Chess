package com.company.move_strategies;

import com.company.chess_board.pieces.*;

import java.util.HashMap;
import java.util.Map;

public class MovePredictorRegistry {

    private static final Map<Class<? extends Piece>, MovePredictor> registry = new HashMap<>();

    static {
        registry.put(King.class, new KingMovePredictor());
        registry.put(Queen.class, new QueenMovePredictor());
        registry.put(Bishop.class, new BishopMovePredictor());
        registry.put(Knight.class, new KnightMovePredictor());
        registry.put(Rook.class, new RookMovePredictor());
        registry.put(Pawn.class, new PawnMovePredictor());
    }

    public static MovePredictor getPredictor(Piece piece) {
        return registry.get(piece.getClass());
    }
}
