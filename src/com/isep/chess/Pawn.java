package com.isep.chess;

/**
 * Class Pawn
 */
public class Pawn extends Piece {

    //
    // Fields
    //

    //
    // Constructors
    //
    public Pawn (Position position, int color) {
        super(position, color);
    }

    //
    // @Override Methods
    //
    @Override
    public String toString() {
        return "P";
    }

    //
    // Methods
    //

}
