package com.isep.chess;

import static java.lang.Boolean.TRUE;

public class Cell {
    private final Position position;
    private boolean isEmpty;
    private Piece currentPiece;

    public Cell(Position position, Piece currentPiece) {
        this.position = position;
        this.currentPiece = currentPiece;
        if (currentPiece == null) {
            isEmpty = TRUE;
        }
    }

    public Position getPosition() {
        return position;
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }

}
