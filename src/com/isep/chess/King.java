package com.isep.chess;

/**
 * Class King
 */
public class King extends Piece {

    //
    // Fields
    //

    //
    // Constructors
    //
    public King (Position position, int color) {
        super(position, color);
    }

    //
    // @Override Methods
    //
    @Override
    public String toString() {
        return "K";
    }

    //
    // Methods
    //

}