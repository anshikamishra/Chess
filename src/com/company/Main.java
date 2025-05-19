package com.company;

import com.company.chess_board.Cell;
import com.company.chess_board.Color;
import com.company.chess_board.Move;
import com.company.chess_board.pieces.Piece;
import com.company.game_engine.ActionValidator;
import com.company.game_engine.Game;
import com.company.game_engine.GameDisplay;
import com.company.player.Player;

import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Game game = new Game.Builder()
                .withFirstPlayer(new Player("1", "Sally", Color.WHITE))
                .withSecondPlayer(new Player("2", "Harry", Color.BLACK))
                .build();

        GameDisplay display = new GameDisplay(game);
        display.displayBoard();

        while (true) {
            display.displayPlayers();
            Player currentPlayer = game.getCurrentPlayer();

            // 1. Ask player to choose a piece
            System.out.print("Select a cell to move the piece (row col) > ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            Cell chosenCell = game.getCellByRowAndColumn(row, col);

            // 2. Validate the cell
            if (!ActionValidator.isLegalCell(chosenCell)) {
                System.out.println("Error! You chose an illegal cell.");
                continue;
            }
            if (!ActionValidator.isCellEmpty(chosenCell, currentPlayer)) {
                System.out.println("Error! You chose a non-empty cell.");
                continue;
            }
            if (!ActionValidator.isPlayersPiece(chosenCell, currentPlayer)) {
                System.out.println("Error! You chose wrong color piece.");
                continue;
            }

            // 3. Show the possible moves for the piece
            Piece chosenPiece = chosenCell.getPiece();
            Map<Integer, Cell> possibleMoveMap = game.getMovesByPiece(chosenPiece);

            if (possibleMoveMap.isEmpty()) {
                System.out.println("Warning ! No available moves for the piece.");
                continue;
            }

            System.out.println("Moves available :- ");
            possibleMoveMap.forEach((key, cell) -> System.out.println(key + ": " + cell.getCoordinates()));

            // 4. Ask player to choose a move
            System.out.print("Choose a valid move index (0 to discard piece selection) > ");
            int moveIndex = scanner.nextInt();
            if (moveIndex == 0) {
                continue;
            }
            if (moveIndex < 0 || moveIndex > possibleMoveMap.size()) {
                System.out.println("Error! You chose an invalid move index.");
                continue;
            }

            // 5. Move the piece
            Cell targetCell = possibleMoveMap.get(moveIndex);
            Move move = new Move(chosenPiece, targetCell, currentPlayer);
            boolean gameOver = game.applyMoveAndEvaluate(move);

            display.displayBoard();

            if (gameOver) {
                display.displayGameResult();
                break;
            }
        }
    }
}
