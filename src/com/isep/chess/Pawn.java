package com.isep.chess;

public class Pawn extends Piece {
    public Pawn(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board) {
        if (position.getColumn() == newPosition.getColumn()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "P";
    }
}
