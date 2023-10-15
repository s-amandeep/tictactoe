package com.example.tictactoe.kaata;

import com.example.tictactoe.kaata.models.*;
import com.example.tictactoe.kaata.strategies.Playing.RandomPlayingStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {

    private static final int BOARD_SIZE = 3;

    @Test
    public void testCreateGame(){
        Game game = Game.builder()
                .withSize(BOARD_SIZE)
                .withPlayer(HumanPlayer.builder()
                        .symbol(Symbol.X)
                        .user(new User())
                        .build())
                .withPlayer(BotPlayer.builder()
                        .symbol(Symbol.O)
                        .level(GameLevel.EASY)
                        .playingStrategy(new RandomPlayingStrategy())
                        .build())
                .build();
//        Game game = Game.builder()
//                .withSize(BOARD_SIZE)
//                .withPlayer(new HumanPlayer(Symbol.X, new User()))
//                .withPlayer(new BotPlayer(Symbol.O, GameLevel.EASY, new RandomPlayingStrategy()))
//                .build();
//        Board board = new Board(BOARD_SIZE);
//        Player humanPlayer = new HumanPlayer(Symbol.X, new User());
//        Player botPlayer = new BotPlayer(Symbol.O, GameLevel.EASY, new RandomPlayingStrategy());
//        Game game = new Game(board, List.of(humanPlayer, botPlayer), DEFAULT_STATUS);
    }

    @Test
    public void testCreateBoard(){
        Board board = new Board(BOARD_SIZE);
        int rowSize = board.getCells().size();
        assertEquals(3, rowSize, "If ctor of board is called with n, it should create n rows");

        int colSize = board.getCells().get(0).size();
        assertEquals(3, colSize, "If ctor of board is called with n, it should create n columns");
    }
}
