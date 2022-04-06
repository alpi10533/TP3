package com.isep.chess;

public class Position {
    private char column;
    private int row;

    public Position (int column, int row) {
        char[] columnNames = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        this.column = columnNames[column - 1];
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getColumnInt() {
        return column - 96;     // 97 = a
    }

    public int getRow() {
        return row;
    }

    public String toString() {
        return column + String.valueOf(row);
    }
}
