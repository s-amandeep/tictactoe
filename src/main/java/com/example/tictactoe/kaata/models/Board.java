package com.example.tictactoe.kaata.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Getter
public class Board {
    private int size;
    private List<List<BoardCell>> cells = new ArrayList<>();

    public Board(int size) {
        this.size = size;
        this.cells = initializeCells(size);
    }

    private List<List<BoardCell>> initializeCells(int size) {
//        List<BoardCell> firstRow = Collections.nCopies(size, new BoardCell());
//        return Collections.nCopies(size, firstRow);
        List<List<BoardCell>> cells = new ArrayList<>();
        IntStream.range(0, size).forEach(row -> {
            List<BoardCell> rowCells = new ArrayList<>();
            IntStream.range(0, size).forEach(column -> rowCells.add(new BoardCell(row, column)));
            cells.add(rowCells);
        });
        return cells;
    }

    public boolean isEmpty(int row, int column) {
//        return cells.get(row).get(column).getSymbol() == null;
        return getBoardCell(row,column).getSymbol() == null;
    }

    private BoardCell getBoardCell(int row, int column) {
        return cells.get(row).get(column);
    }

    public void updateMove(BoardCell move) {
        int row = move.getRow();
        int column = move.getColumn();
        BoardCell cell = getBoardCell(row, column);
        cell.setSymbol(move.getSymbol());
//        cell.toBuilder().row(row).column(column).symbol(move.getSymbol());
    }

    public void printBoard() {
        for (int i = 0; i < cells.size(); ++i) {
            for (int j = 0; j < cells.size(); ++j) {
                Symbol symbol = cells.get(i).get(j).getSymbol();

                if (symbol == null) {
                    System.out.printf(" | - | ");
                } else {
                    System.out.printf(" | " + symbol + " | ");
                }
            }
            System.out.printf("\n");
        }
    }

    public List<BoardCell> getEmptyCells() {
        // Iterate over the cells
        // Flatten the array 2D => 1D
        //Filter out the cells where symbol != null

        // Get list of streams and combine into one
        return cells.stream()
                .flatMap(List::stream)
                .filter(cell -> cell.getSymbol() == null)
                .toList();

    }
}
