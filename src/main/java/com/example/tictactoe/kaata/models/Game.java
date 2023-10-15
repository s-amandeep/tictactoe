package com.example.tictactoe.kaata.models;

import com.example.tictactoe.kaata.exceptions.InvalidMoveException;
import com.example.tictactoe.kaata.exceptions.InvalidPlayerException;
import com.example.tictactoe.kaata.strategies.Winning.RowWinningStrategy;
import com.example.tictactoe.kaata.strategies.Winning.WinningStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Game {
    private Board board;
    private List<Player> players = new ArrayList<>();
    private GameStatus status;
    private int nextPlayerIndex = 0;
    private static final int PLAYER_COUNT = 2;
    private static final GameStatus DEFAULT_STATUS = GameStatus.IN_PROGRESS;
    private List<WinningStrategy> winningStrategies = List.of(new RowWinningStrategy());
    private Player winner;

    public void start() {
        // Assign random value to nextPlayerIndex
        // GET random value between 0 and 1
        nextPlayerIndex = (int) (Math.random() * players.size());

        // Set the game status to IN_PROGRESS
        status = GameStatus.IN_PROGRESS;
    }

    public void makeMove() {
        // Get the next player && Get the next move from player
        BoardCell move = getNextMove();
        // Update the board
        board.updateMove(move);
        // Check for winner
        if (checkWinner(move.getSymbol())){
            status = GameStatus.FINISHED;
            winner = getNextPlayer();
            return;
        }
        // Check for draw
        if (checkDraw()){
            status = GameStatus.DRAWN;
            return;
        }
        // Update the next player
        nextPlayerIndex = (nextPlayerIndex+1) % players.size();
    }

    private BoardCell getNextMove() {
        Player player = players.get(nextPlayerIndex);
        BoardCell move = player.makeMove(board);

        // Validate the move
        validateMove(move);

        return move;
    }

    private void validateMove(BoardCell move) {
        if (!board.isEmpty(move.getRow(), move.getColumn())){
            throw new InvalidMoveException(move.getRow(), move.getColumn());
        }
    }

    private boolean checkWinner(Symbol symbol) {

        for (WinningStrategy strategy: winningStrategies){
            boolean hasWinner = strategy.checkWinner(getBoard(), symbol);
            if (hasWinner){
                return true;
            }
        }
        return false;
    }

    private boolean checkDraw() {
        return false;
    }

    public static Builder builder(){
        return new Builder();
    }

    public Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    public static class Builder {
        private Game game;

        private Builder() {
            game = new Game();
        }

        public Builder withSize(int size) {
            this.game.board = new Board(size);
            return this;
        }

        public Builder withPlayer(Player player) {
            this.game.getPlayers().add(player);
            return this;
        }

//        public Builder withStatus(GameStatus status) {
//            this.game.status = status;
//            return this;
//        }

        public Game build() {
            boolean isValid = validate();

            if (!isValid) {
                throw new InvalidPlayerException();
            }

            Game newGame = new Game();
            newGame.players = game.players;
            newGame.board = game.board;
            newGame.status = DEFAULT_STATUS;

            return newGame;
        }

        private boolean validate() {

            List<Player> players = game.players;
            // Check no of players
            if (players.size() != PLAYER_COUNT) {
                return false;
            }

            // Check if symbols are unique
            Set<Symbol> symbols = players.stream()
                    .map(Player::getSymbol)
                    .collect(Collectors.toSet());

            return symbols.size() == PLAYER_COUNT;
        }
    }
}
