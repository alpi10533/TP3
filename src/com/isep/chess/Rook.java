package com.isep.chess;

public class Rook extends Piece {
    public Rook(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board) {
        return false;
    }

    @Override
    public String toString() {
        return "R";
    }
}
