package com.company.game_engine;

import com.company.chess_board.*;
import com.company.chess_board.pieces.Piece;
import com.company.game_ending_strategies.CheckMateStrategy;
import com.company.game_ending_strategies.GameOverStrategies;
import com.company.game_ending_strategies.StaleMateStrategy;
import com.company.move_strategies.MovePredictorRegistry;
import com.company.player.Player;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {

    private final UUID gameId;
    private final Board board;
    private final Map<Color, Player> players;
    private final GameOverStrategies checkmate;
    private final GameOverStrategies stalemate;
    private GameStatus gameStatus;
    private List<Move> moveHistory;
    private Player currentPlayer;
    private Player winner;

    private Game(Builder builder) {
        this.gameId = UUID.randomUUID();
        this.board = builder.board;
        this.players = builder.players;
        this.checkmate = new CheckMateStrategy();
        this.stalemate = new StaleMateStrategy();
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moveHistory = new ArrayList<>();
        this.currentPlayer = this.players.get(Color.WHITE);
    }

    public UUID getGameId() {
        return gameId;
    }

    public Board getBoard() {
        return board;
    }

    public Map<Color, Player> getPlayers() {
        return players;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public List<Move> getMoveHistory() {
        return moveHistory;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean applyMoveAndEvaluate(Move move) {
        if (!isValidMove(move)) {
            throw new RuntimeException("Invalid move.");
        }

        BoardOperator.updateCellAndPieceAssociation(this.board, move);
        moveHistory.add(move);
        toggleTurn();

        if (checkmate.ifGameEnded(this.board, move)) {
            this.gameStatus = GameStatus.CHECKMATE;
            this.winner = move.getPlayedBy();
            return true;
        }
        if (stalemate.ifGameEnded(this.board, move)) {
            this.gameStatus = GameStatus.STALEMATE;
            this.winner = null;
            return true;
        }

        return false;
    }

    public void replayMoves() {
        List<Move> moveHistoryCopy = new ArrayList<>(this.moveHistory);
        resetGame();
        moveHistoryCopy.forEach(this::applyMoveAndEvaluate);
    }

    public void resetGame() {
        BoardOperator.resetBoard(board);
        this.currentPlayer = this.getPlayers().get(Color.WHITE);
        this.moveHistory = new ArrayList<>();
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public Map<Integer, Piece> getActivePieces(Color color) {
        List<Piece> pieceList = board.getPieces().get(color).stream()
                .filter(p -> p.getCellValue() != null)
                .collect(Collectors.toList());

        return IntStream.range(0, pieceList.size())
                .boxed()
                .collect(Collectors.toMap(i -> i + 1, pieceList::get));
    }

    public Map<Integer, Cell> getMovesByPiece(Piece piece) {
        List<Cell> moveList = MovePredictorRegistry.getPredictor(piece).getPossibleTargetCells(piece, board);

        return IntStream.range(0, moveList.size())
                .boxed()
                .collect(Collectors.toMap(i -> i + 1, moveList::get));
    }

    public Cell getCellByRowAndColumn(int row, int col) {
        return BoardOperator.getCellByCoordinates(this.board, new Coordinates(row, col));
    }

    private void toggleTurn() {
        this.currentPlayer = this.currentPlayer == this.players.get(Color.WHITE) ?
                this.players.get(Color.BLACK) : this.players.get(Color.WHITE);
    }

    private boolean isValidMove(Move move) {
        Cell targetCell = move.getTargetCell();
        Player player = move.getPlayedBy();
        Piece piece = move.getPiece();

        if (targetCell == null || player == null || piece == null) {
            return false;
        }
        // Player selected inactive piece
        if (piece.getCellValue() == null) {
            return false;
        }
        // Player playing other team's piece.
        if (!player.getColor().equals(piece.getPieceColor())) {
            return false;
        }
        // Player attacking its own piece.
        if (targetCell.getPiece() != null && player.getColor().equals(targetCell.getPiece().getPieceColor())) {
            return false;
        }

        return true;
    }

    public static class Builder {

        private final Board board;
        private final Map<Color, Player> players;

        public Builder() {
            this.board = BoardOperator.initializeBoard();
            this.players = new HashMap<>();
        }

        public Builder withSecondPlayer(Player player) {
            this.players.put(player.getColor(), player);
            return this;
        }

        public Builder withFirstPlayer(Player player) {
            this.players.put(player.getColor(), player);
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
