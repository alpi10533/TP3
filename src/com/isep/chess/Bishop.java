package com.isep.chess;

/**
 * Class Bishop
 */
public class Bishop extends Piece {

    //
    // Fields
    //

    //
    // Constructors
    //
    public Bishop (Position position, int color) {
        super(position, color);
    }

    //
    // @Override Methods
    //
    @Override
    public String toString() {
        return "B";
    }

    //
    // Methods
    //

}
