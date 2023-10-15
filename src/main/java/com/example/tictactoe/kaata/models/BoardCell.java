package com.example.tictactoe.kaata.models;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
//@Builder(toBuilder = true)
public class BoardCell {
    private int row;
    private int column;
    private Symbol symbol;

    public BoardCell(int row, int column) {
        this.row = row;
        this.column = column;
    }
}
