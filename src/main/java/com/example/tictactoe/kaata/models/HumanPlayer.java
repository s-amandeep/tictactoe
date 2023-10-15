package com.example.tictactoe.kaata.models;

import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

@SuperBuilder
// Extrinsic State
public class HumanPlayer extends Player{
    private User user;

//    @Builder.Default
//    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(Symbol symbol, User user) {
        super(symbol);
        this.user = user;
    }

    @Override
    public BoardCell makeMove(Board board) {

        System.out.println("Enter next row and column: ");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        return new BoardCell(row, column, getSymbol());

    }
}
