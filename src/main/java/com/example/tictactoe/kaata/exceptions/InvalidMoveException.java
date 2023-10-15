package com.example.tictactoe.kaata.exceptions;

public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(int row, int column) {
        super("Invalid move as the row " + row + " and " + column + " is already occupied");
    }
}
