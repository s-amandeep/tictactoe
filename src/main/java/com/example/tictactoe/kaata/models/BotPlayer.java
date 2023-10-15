package com.example.tictactoe.kaata.models;

import com.example.tictactoe.kaata.strategies.Playing.PlayingStrategy;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class BotPlayer extends Player{
    private GameLevel level;
    private PlayingStrategy playingStrategy;

    public BotPlayer(Symbol symbol, GameLevel level, PlayingStrategy playingStrategy) {
        super(symbol);
        this.level = level;
        this.playingStrategy = playingStrategy;
    }

    @Override
    public BoardCell makeMove(Board board) {
        BoardCell boardCell = playingStrategy.makeMove(board);
        boardCell.setSymbol(getSymbol());
        return boardCell;
    }
}
