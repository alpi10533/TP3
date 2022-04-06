package com.isep.chess;

/**
 * Class Quenn
 */
public class Queen extends Piece {

    //
    // Fields
    //

    //
    // Constructors
    //
    public Queen (Position position, int color) {
        super(position, color);
    }

    //
    // @Override Methods
    //
    @Override
    public String toString() {
        return "Q";
    }

    //
    // Methods
    //

}
