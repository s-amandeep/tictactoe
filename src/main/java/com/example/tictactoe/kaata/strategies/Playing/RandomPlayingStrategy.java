package com.example.tictactoe.kaata.strategies.Playing;

import com.example.tictactoe.kaata.models.Board;
import com.example.tictactoe.kaata.models.BoardCell;
import com.example.tictactoe.kaata.strategies.Playing.PlayingStrategy;

import java.util.List;

public class RandomPlayingStrategy implements PlayingStrategy {
    @Override
    public BoardCell makeMove(Board board) {
        // Return boardcell from list of available cells

        // Get list of empty cells
        List<BoardCell> emptyCells = board.getEmptyCells();

        // Generate a random index from list of cells
        int randomIndex = (int) (Math.random()*emptyCells.size());

        // Return random cell
        BoardCell boardCell = emptyCells.get(randomIndex);
        return new BoardCell(boardCell.getRow(), boardCell.getColumn());
    }
}
