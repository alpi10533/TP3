package com.isep.chess;

public class Cell {
    private final Position position;
    private boolean isEmpty;
    private Piece currentPiece;

    public Cell(Position position, boolean isEmpty, Piece currentPiece) {
        this.position = position;
        this.isEmpty = isEmpty;
        this.currentPiece = !isEmpty ? currentPiece : null;
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
