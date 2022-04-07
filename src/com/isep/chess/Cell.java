package com.isep.chess;

/**
 * Class Cell
 */
public class Cell {

    //
    // Fields
    //
    private final Position position;
    private boolean isEmpty;
    private Piece currentPiece;

    //
    // Constructor
    //
    public Cell(Position position, Piece currentPiece) {
        this.position = position;
        this.currentPiece = currentPiece;
        if (currentPiece == null) {
            isEmpty = true;
        }
    }

    //
    // Methods
    //
    public Position getPosition() {
        return position;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(Piece newPiece) {
        currentPiece = newPiece;
        isEmpty = currentPiece == null;
    }

}
