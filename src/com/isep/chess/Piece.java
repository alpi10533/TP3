package com.isep.chess;

/**
 * Abstract Class Piece
 */
public abstract class Piece {

    //
    // Fields
    //
    private Position position;
    private final int color;

    //
    // Constructor
    //
    public Piece (Position position, int color) {
        this.position = position;
        this.color = color; // 1 = Black | 2 = White
    }

    //
    // Methods
    //
    public int getColor() {
        return color;
    }

}
