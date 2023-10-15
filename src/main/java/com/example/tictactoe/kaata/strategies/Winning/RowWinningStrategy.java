package com.example.tictactoe.kaata.strategies.Winning;

import com.example.tictactoe.kaata.models.Board;
import com.example.tictactoe.kaata.models.BoardCell;
import com.example.tictactoe.kaata.models.Symbol;

import java.util.List;

public class RowWinningStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Symbol symbol) {
        for (List<BoardCell> rows: board.getCells()){
            boolean isWinner = true;
            for (BoardCell cell: rows){
                if (cell.getSymbol() != symbol){
                    isWinner = false;
                    break;
                }
            }

            if (isWinner){
                return true;
            }
        }

        return false;
    }
}
