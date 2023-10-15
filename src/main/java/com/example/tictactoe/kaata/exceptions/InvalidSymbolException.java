package com.example.tictactoe.kaata.exceptions;

public class InvalidSymbolException extends RuntimeException{
    public InvalidSymbolException(){
        super("Invalid Symbol. Use X or O");
    }
}
