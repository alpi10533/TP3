package com.isep.chess;

import java.util.ArrayList;

/**
 * Abstract Class Piece
 */
public abstract class Piece {

    //
    // Fields
    //
    private Position position;
    private final int color;
    private final String type;
    private Boolean moved;

    //
    // Constructor
    //
    public Piece (Position position, int color, String type, Boolean moved) {
        this.position = position;
        this.color = color; // 1 = Black | 2 = White
        this.type = type;  // R = Rook | N = Knight | B = Bishop | Q = Queen | K = King | P = Pawn
        this.moved = moved;
    }

    //
    // Methods
    //
    public int getColor() {
        return color;
    }

    public String toString() {
        return type;
    }

    public void setMoved() {
        moved = true;
    }

    public void setPosition(Position newPosition) {
        position = newPosition;
    }

    public boolean isValidToMove (int expectedRow, int expectedColumn, Cell[][] board) {
        ArrayList<String> valid = new ArrayList<>();
        String expected = String.valueOf(expectedRow) + String.valueOf(expectedColumn);
        switch (type) {
            case "K" -> {
                //déplacement vers le centre NOIR
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)+1<=7) {
                    if (!board[(position.getRow()-1)+1][(position.getColumnInt()-1)].getIsEmpty()){
                        if (board[(position.getRow()-1)+1][(position.getColumnInt()-1)].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()));
                        }
                    } else if (board[(position.getRow()-1)+1][(position.getColumnInt()-1)].getIsEmpty()){
                        valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()));
                    }
                }
                //délacement vers l'extérieur NOIR
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)-1>=0) {
                    if (!board[(position.getRow()-1)-1][(position.getColumnInt()-1)].getIsEmpty()){
                        if (board[(position.getRow()-1)-1][(position.getColumnInt()-1)].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()));
                        }
                    } else if (board[(position.getRow()-1)-1][(position.getColumnInt()-1)].getIsEmpty()){
                        valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()));
                    }
                }
                //déplacement vers le centre BLANC
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)-1>=0) {
                    if (!board[(position.getRow()-1)-1][(position.getColumnInt()-1)].getIsEmpty()){
                        if (board[(position.getRow()-1)-1][(position.getColumnInt()-1)].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()));
                        }
                    } else if (board[(position.getRow()-1)-1][(position.getColumnInt()-1)].getIsEmpty()){
                        valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()));
                    }
                }
                //délacement vers l'extérieur BLANC
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)+1<=7) {
                    if (!board[(position.getRow()-1)+1][(position.getColumnInt()-1)].getIsEmpty()){
                        if (board[(position.getRow()-1)+1][(position.getColumnInt()-1)].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()));
                        }
                    } else if (board[(position.getRow()-1)+1][(position.getColumnInt()-1)].getIsEmpty()){
                        valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()));
                    }
                }
                //déplacement droit
                if ((position.getColumnInt()-1)+1<=7) {
                    if (!board[position.getRow()-1][((position.getColumnInt()-1)+1)].getIsEmpty()){
                        if (board[position.getRow()-1][((position.getColumnInt()-1)+1)].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow())+String.valueOf(position.getColumnInt()+1));
                        }
                    } else if (board[position.getRow()-1][((position.getColumnInt()-1)+1)].getIsEmpty()){
                        valid.add(String.valueOf(position.getRow())+String.valueOf(position.getColumnInt()+1));
                    }
                }
                //déplacement gauche
                if ((position.getColumnInt()-1)-1>=0) {
                    if (!board[position.getRow()-1][((position.getColumnInt()-1)-1)].getIsEmpty()){
                        if (board[position.getRow()-1][((position.getColumnInt()-1)-1)].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow())+String.valueOf(position.getColumnInt()-1));
                        }
                    } else if (board[position.getRow()-1][((position.getColumnInt()-1)-1)].getIsEmpty()){
                        valid.add(String.valueOf(position.getRow())+String.valueOf(position.getColumnInt()-1));
                    }
                }
                //déplacement diagonale vers le centre droite NOIR
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)+1<=7 && (position.getColumnInt()-1)+1<=7) {
                    if (!board[(position.getRow()-1)+1][((position.getColumnInt()-1)+1)].getIsEmpty()){
                        if (board[(position.getRow()-1)+1][((position.getColumnInt()-1)+1)].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()+1));
                        }
                    } else if (board[(position.getRow()-1)+1][((position.getColumnInt()-1)+1)].getIsEmpty()){
                        valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()+1));
                    }
                }
                //déplacement diagonale vers le centre gauche NOIR
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)+1<=7 && (position.getColumnInt()-1)-1>=0) {
                    if (!board[(position.getRow()-1)+1][(position.getColumnInt()-1)-1].getIsEmpty()){
                        if (board[(position.getRow()-1)+1][(position.getColumnInt()-1)-1].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()-1));
                        }
                    } else if (board[(position.getRow()-1)+1][(position.getColumnInt()-1)-1].getIsEmpty()){
                        valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()-1));
                    }
                }
                //déplacement diagonale vers l'extérieur droite NOIR
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)-1>=0 && (position.getColumnInt()-1)+1<=7) {
                    if (!board[(position.getRow()-1)-1][((position.getColumnInt()-1)+1)].getIsEmpty()){
                        if (board[(position.getRow()-1)-1][((position.getColumnInt()-1)+1)].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()+1));
                        }
                    } else if (board[(position.getRow()-1)-1][((position.getColumnInt()-1)+1)].getIsEmpty()){
                        valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()+1));
                    }
                }
                //déplacement diagonale vers l'extérieur gauche NOIR
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)-1>=0 && (position.getColumnInt()-1)-1>=0) {
                    if (!board[(position.getRow()-1)-1][((position.getColumnInt()-1)-1)].getIsEmpty()){
                        if (board[(position.getRow()-1)-1][((position.getColumnInt()-1)-1)].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()-1));
                        }
                    } else if (board[(position.getRow()-1)-1][((position.getColumnInt()-1)-1)].getIsEmpty()){
                        valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()-1));
                    }
                }
                //déplacement diagonale vers le centre droite BLANC
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)-1>=0 && (position.getColumnInt()-1)+1<=7) {
                    if (!board[(position.getRow()-1)-1][((position.getColumnInt()-1)+1)].getIsEmpty()){
                        if (board[(position.getRow()-1)-1][((position.getColumnInt()-1)+1)].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()+1));
                        }
                    } else if (board[(position.getRow()-1)-1][((position.getColumnInt()-1)+1)].getIsEmpty()){
                        valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()+1));
                    }
                }
                //déplacement diagonale vers le centre gauche BLANC
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)-1>=0 && (position.getColumnInt()-1)-1>=0) {
                    if (!board[(position.getRow()-1)-1][(position.getColumnInt()-1)-1].getIsEmpty()){
                        if (board[(position.getRow()-1)-1][(position.getColumnInt()-1)-1].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()-1));
                        }
                    } else if (board[(position.getRow()-1)-1][(position.getColumnInt()-1)-1].getIsEmpty()){
                        valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()-1));
                    }
                }
                //déplacement diagonale vers l'extérieur droite BLANC
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)+1<=7 && (position.getColumnInt()-1)+1<=7) {
                    if (!board[(position.getRow()-1)+1][((position.getColumnInt()-1)+1)].getIsEmpty()){
                        if (board[(position.getRow()-1)+1][((position.getColumnInt()-1)+1)].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()+1));
                        }
                    } else if (board[(position.getRow()-1)+1][((position.getColumnInt()-1)+1)].getIsEmpty()){
                        valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()+1));
                    }
                }
                //déplacement diagonale vers l'extérieur gauche BLANC
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)+1<=7 && (position.getColumnInt()-1)-1>=0) {
                    if (!board[(position.getRow()-1)+1][((position.getColumnInt()-1)-1)].getIsEmpty()){
                        if (board[(position.getRow()-1)+1][((position.getColumnInt()-1)-1)].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()-1));
                        }
                    } else if (board[(position.getRow()-1)+1][((position.getColumnInt()-1)-1)].getIsEmpty()){
                        valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()-1));
                    }
                }
                if (valid.contains(expected)){
                    return true;
                } else {
                    return false;
                }
            }

            case "R" -> {
                //déplacement droite
                int i = 1;
                while (true) {
                    if ((position.getColumnInt()-1)+i<=7) {
                        if (board[position.getRow()-1][(position.getColumnInt()-1)+i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()) + String.valueOf(position.getColumnInt()+i));
                            i++;
                        } else if (board[position.getRow()-1][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()) + String.valueOf(position.getColumnInt()+i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement gauche
                i = 1;
                while (true) {
                    if ((position.getColumnInt()-1)-i>=0) {
                        if (board[position.getRow()-1][(position.getColumnInt()-1)-i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()) + String.valueOf(position.getColumnInt()-i));
                            i++;
                        } else if (board[position.getRow()-1][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()) + String.valueOf(position.getColumnInt()-i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement vers le centre NOIR
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)+i<=7) {
                        if (board[(position.getRow()-1)+i][position.getColumnInt()-1].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()));
                            i++;
                        } else if (board[(position.getRow()-1)+i][position.getColumnInt()-1].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement vers l'extérieur NOIR
                i = 1;
                while (true) {
                    if ((position.getRow()-1)-i>=0) {
                        if (board[(position.getRow()-1)-i][position.getColumnInt()-1].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()));
                            i++;
                        } else if (board[(position.getRow()-1)-i][position.getColumnInt()-1].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement vers le centre BLANC
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)-i>=0) {
                        if (board[(position.getRow()-1)-i][position.getColumnInt()-1].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()));
                            i++;
                        } else if (board[(position.getRow()-1)-i][position.getColumnInt()-1].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement l'extérieur BLANC
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)+i<=7) {
                        if (board[(position.getRow()-1)+i][position.getColumnInt()-1].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()));
                            i++;
                        } else if (board[(position.getRow()-1)+i][position.getColumnInt()-1].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (valid.contains(expected)){
                    return true;
                } else {
                    return false;
                }

            }

            case "P" -> {
                //déplacement vers le centre NOIR
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)+1<=7) {
                    if (board[(position.getRow()-1)+1][(position.getColumnInt()-1)].getIsEmpty()){
                        if (board[(position.getRow()-1)+2][(position.getColumnInt()-1)].getIsEmpty() && !moved) {
                            valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()));
                            valid.add(String.valueOf(position.getRow()+2)+String.valueOf(position.getColumnInt()));
                        } else {
                            valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()));
                        }
                    }
                }
                //déplacement diagonale vers le centre droite NOIR
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)+1<=7 && (position.getColumnInt())-1+1<=7 ) {
                    if (!board[(position.getRow()-1)+1][(position.getColumnInt())-1+1].getIsEmpty()){
                        if (board[(position.getRow()-1)+1][(position.getColumnInt()-1)+1].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()+1));
                        }
                    }
                }
                //déplacement diagonale vers le centre gauche NOIR
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)+1<=7 && (position.getColumnInt()-1)-1>=0 ) {
                    if (!board[(position.getRow()-1)+1][(position.getColumnInt()-1)-1].getIsEmpty()){
                        if (board[(position.getRow()-1)+1][(position.getColumnInt()-1)-1].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()+1)+String.valueOf(position.getColumnInt()-1));
                        }
                    }
                }
                //déplacement vers le centre BLANC
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)-1>=0) {
                    if (board[(position.getRow()-1)-1][(position.getColumnInt()-1)].getIsEmpty()){
                        if ((position.getRow()-1)-2>=0) {
                            if (board[(position.getRow()-1)-2][(position.getColumnInt()-1)].getIsEmpty() && !moved) {
                                valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()));
                                valid.add(String.valueOf(position.getRow()-2)+String.valueOf(position.getColumnInt()));
                            }
                        } else {
                            valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()));
                        }
                    }
                }
                //déplacement diagonale vers le centre droite BLANC
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)-1>=0 && (position.getColumnInt())-1+1<=7 ) {
                    if (!board[(position.getRow()-1)-1][(position.getColumnInt())-1+1].getIsEmpty()){
                        if (board[(position.getRow()-1)-1][(position.getColumnInt()-1)+1].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()+1));
                        }
                    }
                }
                //déplacement diagonale vers le centre gauche BLANC
                if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)-1>=0 && (position.getColumnInt()-1)-1>=1 ) {
                    if (!board[(position.getRow()-1)-1][(position.getColumnInt()-1)-1].getIsEmpty()){
                        if (board[(position.getRow()-1)-1][(position.getColumnInt()-1)-1].getCurrentPiece().getColor() != color) {
                            valid.add(String.valueOf(position.getRow()-1)+String.valueOf(position.getColumnInt()-1));
                        }
                    }
                }
                if (valid.contains(expected)){
                    return true;
                } else {
                    return false;
                }
            }

            case "B" -> {
                //déplacement diagonale vers le centre droite NOIR
                int i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)+i<=7 && (position.getColumnInt()-1)+i<=7) {
                        if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)+i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()+i));
                            i++;
                        } else if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()+i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers le centre gauche NOIR
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)+i<=7 && (position.getColumnInt()-1)-i>=0) {
                        if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)-i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()-i));
                            i++;
                        } else if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)-i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()-i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers l'extérieur droite NOIR
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)-i>=0 && (position.getColumnInt()-1)+i<=7) {
                        if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)+i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()+i));
                            i++;
                        } else if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()+i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers l'extérieur gauche NOIR
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)-i>=0 && (position.getColumnInt()-1)-i>=0) {
                        if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)-i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()-i));
                            i++;
                        } else if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()-i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers l'extérieur droite BLANC
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)+i<=7 && (position.getColumnInt()-1)+i<=7) {
                        if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)+i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()+i));
                            i++;
                        } else if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()+i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers l'extérieur gauche BLANC
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)+i<=7 && (position.getColumnInt()-1)-i>=0) {
                        if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)-i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()-i));
                            i++;
                        } else if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)-i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()-i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers le centre droite BLANC
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)-i>=0 && (position.getColumnInt()-1)+i<=7) {
                        if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)+i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()+i));
                            i++;
                        } else if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()+i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers le centre gauche BLANC
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)-i>=0 && (position.getColumnInt()-1)-i>=0) {
                        if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)-i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()-i));
                            i++;
                        } else if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()-i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (valid.contains(expected)){
                    return true;
                } else {
                    return false;
                }
            }

            case "Q" -> {
                //déplacement droite
                int i = 1;
                while (true) {
                    if ((position.getColumnInt()-1)+i<=7) {
                        if (board[position.getRow()-1][(position.getColumnInt()-1)+i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()) + String.valueOf(position.getColumnInt()+i));
                            i++;
                        } else if (board[position.getRow()-1][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()) + String.valueOf(position.getColumnInt()+i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement gauche
                i = 1;
                while (true) {
                    if ((position.getColumnInt()-1)-i>=0) {
                        if (board[position.getRow()-1][(position.getColumnInt()-1)-i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()) + String.valueOf(position.getColumnInt()-i));
                            i++;
                        } else if (board[position.getRow()-1][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()) + String.valueOf(position.getColumnInt()-i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement vers le centre NOIR
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)+i<=7) {
                        if (board[(position.getRow()-1)+i][position.getColumnInt()-1].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()));
                            i++;
                        } else if (board[(position.getRow()-1)+i][position.getColumnInt()-1].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement vers l'extérieur NOIR
                i = 1;
                while (true) {
                    if ((position.getRow()-1)-i>=0) {
                        if (board[(position.getRow()-1)-i][position.getColumnInt()-1].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()));
                            i++;
                        } else if (board[(position.getRow()-1)-i][position.getColumnInt()-1].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement vers le centre BLANC
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)-i>=0) {
                        if (board[(position.getRow()-1)-i][position.getColumnInt()-1].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()));
                            i++;
                        } else if (board[(position.getRow()-1)-i][position.getColumnInt()-1].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement l'extérieur BLANC
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)+i<=7) {
                        if (board[(position.getRow()-1)+i][position.getColumnInt()-1].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()));
                            i++;
                        } else if (board[(position.getRow()-1)+i][position.getColumnInt()-1].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers le centre droite NOIR
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)+i<=7 && (position.getColumnInt()-1)+i<=7) {
                        if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)+i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()+i));
                            i++;
                        } else if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()+i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers le centre gauche NOIR
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)+i<=7 && (position.getColumnInt()-1)-i>=0) {
                        if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)-i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()-i));
                            i++;
                        } else if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)-i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()-i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers l'extérieur droite NOIR
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)-i>=0 && (position.getColumnInt()-1)+i<=7) {
                        if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)+i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()+i));
                            i++;
                        } else if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()+i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers l'extérieur gauche NOIR
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 1 && (position.getRow()-1)-i>=0 && (position.getColumnInt()-1)-i>=0) {
                        if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)-i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()-i));
                            i++;
                        } else if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()-i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers l'extérieur droite BLANC
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)+i<=7 && (position.getColumnInt()-1)+i<=7) {
                        if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)+i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()+i));
                            i++;
                        } else if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()+i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers l'extérieur gauche BLANC
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)+i<=7 && (position.getColumnInt()-1)-i>=0) {
                        if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)-i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()-i));
                            i++;
                        } else if (board[(position.getRow()-1)+i][(position.getColumnInt()-1)-i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()+i) + String.valueOf(position.getColumnInt()-i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers le centre droite BLANC
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)-i>=0 && (position.getColumnInt()-1)+i<=7) {
                        if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)+i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()+i));
                            i++;
                        } else if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()+i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                //déplacement diagonale vers le centre gauche BLANC
                i = 1;
                while (true) {
                    if (board[(position.getRow()-1)][(position.getColumnInt()-1)].getCurrentPiece().getColor() == 2 && (position.getRow()-1)-i>=0 && (position.getColumnInt()-1)-i>=0) {
                        if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)-i].getIsEmpty()) {
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()-i));
                            i++;
                        } else if (board[(position.getRow()-1)-i][(position.getColumnInt()-1)+i].getCurrentPiece().getColor() != color){
                            valid.add(String.valueOf(position.getRow()-i) + String.valueOf(position.getColumnInt()-i));
                            break;
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (valid.contains(expected)){
                    return true;
                } else {
                    return false;
                }
            }

            case "N" -> {}
        }
        return false;
    }

}
