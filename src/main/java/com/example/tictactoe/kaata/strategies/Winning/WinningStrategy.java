package com.example.tictactoe.kaata.strategies.Winning;

import com.example.tictactoe.kaata.models.Board;
import com.example.tictactoe.kaata.models.Symbol;

public interface WinningStrategy {

    boolean checkWinner(Board board, Symbol symbol);
}
