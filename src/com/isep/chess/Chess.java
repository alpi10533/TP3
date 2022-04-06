package com.isep.chess;

import com.isep.utils.InputParser;

public class Chess {

    private Cell[][] board ;
    private Player[] players ;
    private Player currentPlayer;
    private InputParser inputParser;


    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_BLACK = "\u001B[30m";
    public static final String TEXT_YELLOW = "\u001B[33m";

    public Chess() {
        board = new Cell[8][8] ;
        players = new Player[2] ;
        inputParser = new InputParser();
    }

    public void play(){
        createPlayers() ;
        initialiseBoard() ;
        printBoard() ;
        start();
    }

    private void createPlayers(){
        System.out.print("\n");
        String name1 = inputParser.askStringUser("\n- Enter the BLACK player's name : ");
        Player player1 = new Player(name1, 1) ;
        String name2 = inputParser.askStringUser("- Enter the WHITE player's name : ");
        Player player2 = new Player(name2, 2) ;
        players[0] = player1 ;
        players[1] = player2 ;
        currentPlayer = player1 ;
    }

    private void initialiseBoard() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                Position cellPosition = new Position(c + 1, r + 1);
                Piece cellPiece;
                if (cellPosition.toString().matches("[ah][1]")) {
                    cellPiece = new Rook(cellPosition, 1);
                } else if (cellPosition.toString().matches("[bg][1]")) {
                    cellPiece = new Knight(cellPosition, 1);
                } else if (cellPosition.toString().matches("[cf][1]")) {
                    cellPiece = new Bishop(cellPosition, 1);
                } else if (cellPosition.toString().matches("[d][1]")) {
                    cellPiece = new Queen(cellPosition, 1);
                } else if (cellPosition.toString().matches("[e][1]")) {
                    cellPiece = new King(cellPosition, 1);
                } else if (cellPosition.toString().matches("[a-h][2]")) {
                    cellPiece = new Pawn(cellPosition, 1);
                } else if (cellPosition.toString().matches("[ah][8]")) {
                    cellPiece = new Rook(cellPosition, 2);
                } else if (cellPosition.toString().matches("[bg][8]")) {
                    cellPiece = new Knight(cellPosition, 2);
                } else if (cellPosition.toString().matches("[cf][8]")) {
                    cellPiece = new Bishop(cellPosition, 2);
                } else if (cellPosition.toString().matches("[d][8]")) {
                    cellPiece = new Queen(cellPosition, 2);
                } else if (cellPosition.toString().matches("[e][8]")) {
                    cellPiece = new King(cellPosition, 2);
                } else if (cellPosition.toString().matches("[a-h][7]")) {
                    cellPiece = new Pawn(cellPosition, 2);
                } else {
                    cellPiece = null;
                }
                Cell cell = new Cell(cellPosition, cellPiece);
                this.board[r][c] = cell;
            }
        }
    }

    private void printBoard() {
        System.out.print("\n\n");
        System.out.println(TEXT_YELLOW + "   a  b  c  d  e  f  g  h" + TEXT_RESET);
        for (int r = 0; r < 8; r++) {
            System.out.print(TEXT_YELLOW + (r + 1) + " " + TEXT_RESET);
            String row;
            for (int c = 0; c < 8; c++) {
                Cell cell = this.board[r][c];
                if (cell.getIsEmpty()) {
                    row = TEXT_YELLOW + " . " + TEXT_RESET;
                } else {
                    if (cell.getCurrentPiece().getColor() == 1) {
                        row = " " + TEXT_BLACK + cell.getCurrentPiece().toString() + TEXT_RESET + " ";
                    } else {
                        row = " " + cell.getCurrentPiece().toString() + " ";
                    }
                }
                System.out.print(row);
            }
            System.out.print("\n");
        }
    }

    private void start() {
        int condA = 0;
        int condB = 0;
        int condC = 0;
        while (condA == 0) {
            while (condB == 0) {
                System.out.print("\n" + currentPlayer.getName() + ", it is your turn  ... ");
                int selectedRow = inputParser.askIntUser("\n- Enter the row of the piece that you want to move : ");
                while (condC == 0) {
                    if (selectedRow <= 8 && selectedRow >= 1) {
                        condC = 1;
                    } else {
                        System.out.println("\nERROR !");
                        selectedRow = inputParser.askIntUser("\n- Enter the row of the piece that you want to move : ");
                    }
                }
                int selectedColumn = inputParser.askColumnUser("- Enter the column of the piece that you want to move : ");

                if (board[selectedRow-1][selectedColumn-1].getIsEmpty()) {
                    System.out.println("\nERROR - No piece at this position !");
                } else {
                    if ( currentPlayer.getColor() != board[selectedRow-1][selectedColumn-1].getCurrentPiece().getColor()) {
                        System.out.println("\nERROR - This piece it is not yours !");
                    } else {
                        condB = 1;
                    }
                }
            }
        }
    }

}