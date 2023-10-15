package com.example.tictactoe.kaata.exceptions;

public class InvalidPlayerException extends RuntimeException{
    public InvalidPlayerException() {
        super("Invalid list of players");
    }
}
