package com.isep.chess;

import java.util.Arrays;

/**
 * Class Position
 */
public class Position {

    //
    // Fields
    //
    private final String[] columnNames;
    private String column;
    private int row;

    //
    // Constructors
    //
    public Position (int column, int row) {
        columnNames = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
        this.column = columnNames[column - 1];
        this.row = row;
    }

    //
    // Methods
    //
    public String getColumn() {
        return column;
    }

    public int getColumnInt() {
        int[] columnValues = {1, 2, 3, 4, 5, 6, 7, 8};
        return columnValues[Arrays.binarySearch(columnNames, column)];
    }

    public int getRow() {
        return row;
    }

    public String toString() {
        return column + String.valueOf(row);
    }

}
