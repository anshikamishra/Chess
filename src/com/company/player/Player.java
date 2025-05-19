package com.company.player;

import com.company.chess_board.Board;
import com.company.chess_board.Color;
import com.company.chess_board.Move;

public class Player {

    private final String playerId;
    private final String name;
    private final Color color;

    public Player(String playerId, String name, Color color) {
        this.playerId = playerId;
        this.name = name;
        this.color = color;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Move makeMove(Board board) {
        // Check with move predictor
        return null;
    }
}
