package com.company.game_engine;

import com.company.chess_board.*;
import com.company.player.Player;

import java.util.Objects;

public class GameDisplay {

    private Game game;

    public GameDisplay(Game game) {
        this.game = game;
    }

    public void displayBoard() {
        Board board = game.getBoard();
        System.out.println("\n        1        2        3        4        5        6        7        8");
        System.out.println("    +--------+--------+--------+--------+--------+--------+--------+--------+");

        for (int row = Cell.ROW_START; row <= Cell.ROW_END; row++) {
            // First row line: cell coordinates
            System.out.print(" " + row + "  |");
            for (int col = Cell.COL_START; col <= Cell.COL_END; col++) {
                //String coord =  (row * col) < 10 ? " " + (row * col)  : String.valueOf(row * col);
                String coord = row + "x" + col;
                //System.out.printf("  %-6s|", coord);
                System.out.printf("  %-6s|", "");
            }
            System.out.println();

            // Second row line: piece symbol
            System.out.print("    |");
            for (int col = Cell.COL_START; col <= Cell.COL_END; col++) {
                Cell cell = BoardOperator.getCellByCoordinates(board, new Coordinates(row, col));
                String symbol = cell.getPiece() == null ? "  " : cell.getPiece().getPieceSymbol();
                System.out.printf("  %-6s|", symbol);
            }
            System.out.println();

            System.out.println("    +--------+--------+--------+--------+--------+--------+--------+--------+");
        }
    }

    public void displayPlayers() {
        System.out.println("\n");

        Player playerW = game.getPlayers().get(Color.WHITE);
        Player playerB = game.getPlayers().get(Color.BLACK);
        String template = "%s | PlayerW : %s%s | PlayerB : %s%s";
        String message;

        if (Objects.equals(game.getCurrentPlayer().getPlayerId(), playerW.getPlayerId())) {
            message = String.format(template, game.getGameStatus(), playerW.getName(), "*", playerB.getName(), "");
        } else {
            message = String.format(template, game.getGameStatus(), playerW.getName(), "", playerB.getName(), "*");
        }

        System.out.println(message);
    }
    
    public void displayGameResult() {
        if (game.getGameStatus() == GameStatus.CHECKMATE) {
            System.out.println("Game Over. " + game.getWinner().getName() + " won !!");
        } else if (game.getGameStatus() == GameStatus.STALEMATE) {
            System.out.println("Game Tied !");
        }
        System.out.println("\n");
    }
}
