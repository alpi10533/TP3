package com.isep.chess;

import java.util.Scanner;

public class Chess {

    private Cell[][] board ;
    private Player[] players ;
    private Player currentPlayer;

    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001b[40m";

    public Chess() {
        this.board = new Cell[8][8] ;
        this.players = new Player[2] ;
    }

    public void play(){
        createPlayers() ;
        initialiseBoard() ;
        printBoard() ;
    }

    private void createPlayers(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du joueur blanc : ");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1, 0) ;
        System.out.println("Veuillez saisir le nom du joueur noir : ");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2, 1) ;

        this.players[0] = player1 ;
        this.players[1] = player2 ;

        this.currentPlayer = player1 ;

    }

    private void initialiseBoard() {

        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {

                Position cellPosition = new Position(c + 1, r + 1);
                String cellPositionString = cellPosition.toString();
                Piece cellPiece;

                int pieceColor = cellPositionString.matches("[a-h][12]") ? 0 : 1;    // white if piece is in first two rows

                if (cellPositionString.matches("[ah][18]")) {
                    cellPiece = new Rook(cellPosition, pieceColor);
                } else if (cellPositionString.matches("[bg][18]")) {
                    cellPiece = new Knight(cellPosition, pieceColor);
                } else if (cellPositionString.matches("[cf][18]")) {
                    cellPiece = new Bishop(cellPosition, pieceColor);
                } else if (cellPositionString.matches("[d][18]")) {
                    cellPiece = new Queen(cellPosition, pieceColor);
                } else if (cellPositionString.matches("e[18]")) {
                    cellPiece = new King(cellPosition, pieceColor);
                } else if (cellPosition.toString().matches("[a-h][27]")) {
                    cellPiece = new Pawn(cellPosition, pieceColor);
                } else {
                    cellPiece = null;
                }

                Cell cell = new Cell(cellPosition, cellPiece == null, cellPiece);
                this.board[r][c] = cell;
            }
        }
    }

    private void printBoard() {
        for (int r = 7; r >= 0; r--) {
            System.out.print(r + 1 + " ");
            String row;
            for (int c = 0; c < 8; c++) {
                Cell cell = this.board[r][c];

                if (cell.getIsEmpty()) {
                    row = " . ";
                } else {
                    String pieceColorTextCode = cell.getCurrentPiece().getColor() == 0 ? TEXT_RESET : TEXT_RED;
                    row = " " + pieceColorTextCode + cell.getCurrentPiece().toString() + TEXT_RESET + " ";
                }
                System.out.print(row);
            }
            System.out.print("\n");
        }
        System.out.println("   a  b  c  d  e  f  g  h");
    }

}