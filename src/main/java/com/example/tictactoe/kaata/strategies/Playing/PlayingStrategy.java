package com.example.tictactoe.kaata.strategies.Playing;

import com.example.tictactoe.kaata.models.Board;
import com.example.tictactoe.kaata.models.BoardCell;

public interface PlayingStrategy {

    BoardCell makeMove(Board board);
}
