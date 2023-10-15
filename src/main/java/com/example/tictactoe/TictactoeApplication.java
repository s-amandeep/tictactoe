package com.example.tictactoe;

import com.example.tictactoe.kaata.exceptions.InvalidSymbolException;
import com.example.tictactoe.kaata.models.*;
import com.example.tictactoe.kaata.strategies.Playing.RandomPlayingStrategy;

import java.util.Scanner;

// Client code
public class TictactoeApplication {

    private static final int BOARD_SIZE = 3;

    public static void main(String[] args) {
        System.out.println("Welcome to TicTacToe");

        HumanPlayer humanPlayer = getUserInput();

        // Create a Game
        Game game = createGame(humanPlayer);
        // Initialize the Bot player
        // H vs B

        // Start Game
        game.start();
        // Assign the first player
        // Mark the game in progress

        // Start Playing
        // Iteratively call make move till game is either won or drawn
        while (game.getStatus() == GameStatus.IN_PROGRESS){
            Player player = game.getNextPlayer();
            System.out.println("Next player symbol: " + player.getSymbol());

            game.makeMove();
            game.getBoard().printBoard();
        }

        if(game.getStatus() == GameStatus.FINISHED) {
            System.out.println("Game won by player: " + game.getWinner().getSymbol());
        }


    }

    private static HumanPlayer getUserInput() {
        // Ask for user input - name, email, symbol
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Human Player name:");
        String name = scanner.nextLine();

        System.out.println("Enter Human Player email:");
        String email = scanner.nextLine();

        System.out.println("Enter Human Player symbol(X or O):");
        Symbol symbol;
        try {
            symbol = Symbol.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException e){
            throw new InvalidSymbolException();
        };

        User user = new User(name, email, null);
        return new HumanPlayer(symbol, user);
    }

    public static Game createGame(HumanPlayer humanPlayer) {
        return Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(humanPlayer)
                .withPlayer(BotPlayer.builder()
                        .symbol(decideBotSymbol(humanPlayer.getSymbol()))
                        .level(GameLevel.EASY)
                        .playingStrategy(new RandomPlayingStrategy())
                        .build())
                .build();

    }

    private static Symbol decideBotSymbol(Symbol symbol) {
        if (symbol == Symbol.X){
            return Symbol.O;
        }
        return Symbol.X;
    }
}
