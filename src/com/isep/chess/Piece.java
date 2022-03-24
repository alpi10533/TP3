package com.isep.chess;

public abstract class Piece {
    protected Position position;
    protected int color;

    public abstract boolean isValidMove(Position position, Cell[][] board);
    public abstract String toString();

    public int getColor() {
        return color;
    }
}
