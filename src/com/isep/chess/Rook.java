package com.isep.chess;

/**
 * Class Rook
 */
public class Rook extends Piece {

    //
    // Fields
    //

    //
    // Constructors
    //
    public Rook (Position position, int color) {
        super(position, color);
    }

    //
    // @Override Methods
    //
    @Override
    public String toString() {
        return "R";
    }

    //
    // Methods
    //

}
