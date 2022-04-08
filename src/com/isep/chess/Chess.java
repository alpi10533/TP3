package com.isep.chess;

import com.isep.utils.InputParser;

import java.util.Objects;

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
                /***
                if (cellPosition.toString().matches("[ah][1]")) {
                    cellPiece = new Rook(cellPosition, 1);
                } else if (cellPosition.toString().matches("[bg][1]")) {
                    cellPiece = new Knight(cellPosition, 1);
                } else if (cellPosition.toString().matches("[cf][1]")) {
                    cellPiece = new Bishop(cellPosition, 1);
                } **/if (cellPosition.toString().matches("[d][1]")) {
                    cellPiece = new Queen(cellPosition, 1);
                } else if (cellPosition.toString().matches("[e][1]")) {
                    cellPiece = new King(cellPosition, 1);
                } /**else if (cellPosition.toString().matches("[a-h][2]")) {
                    cellPiece = new Pawn(cellPosition, 1);
                } else if (cellPosition.toString().matches("[ah][8]")) {
                    cellPiece = new Rook(cellPosition, 2);
                } else if (cellPosition.toString().matches("[bg][8]")) {
                    cellPiece = new Knight(cellPosition, 2);
                } else if (cellPosition.toString().matches("[cf][8]")) {
                    cellPiece = new Bishop(cellPosition, 2);
                } else if (cellPosition.toString().matches("[d][8]")) {
                    cellPiece = new Queen(cellPosition, 2);
                } **/else if (cellPosition.toString().matches("[e][8]")) {
                    cellPiece = new King(cellPosition, 2);
                } /**else if (cellPosition.toString().matches("[a-h][7]")) {
                    cellPiece = new Pawn(cellPosition, 2);
                } **/else {
                    cellPiece = null;
                }
                Cell cell = new Cell(cellPosition, cellPiece);
                board[r][c] = cell;
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
        int condB1 = 0;
        int condB2 = 0;
        int condC = 0;
        int condD = 0;
        int selectedRow = 0;
        int selectedColumn = 0;
        int expectedRow = 0;
        int expectedColumn = 0;
        int success = 0;
        while (condA == 0) {
            while (condB1 == 0) {
                if (success == 0) {
                    printBoard() ;
                    System.out.print("\n" + currentPlayer.getName() + ", your turn is starting  ... \n");
                } else if ((success == 1)) {
                    printBoard() ;
                    System.out.print("\n" + currentPlayer.getName() + ", your turn is restarting  ... \n");
                } else if (success == 2) {
                    System.out.print("\n" + currentPlayer.getName() + ", it is your turn  ... \n");
                } else if (success == 4) {
                    System.out.print("\n" + " GAME OVER !");
                    condB1 = 1;
                    condB2 = 1;
                    condA = 1;
                }
                selectedRow = inputParser.askIntUser("\n- Enter the row of the piece that you want to move : ");
                while (condC == 0) {
                    if (selectedRow <= 8 && selectedRow >= 1) {
                        condC = 1;
                    } else {
                        System.out.println("\nERROR !");
                        selectedRow = inputParser.askIntUser("\n- Enter the row of the piece that you want to move : ");
                    }
                }
                selectedColumn = inputParser.askColumnUser("\n- Enter the column of the piece that you want to move : ");

                if (board[selectedRow-1][selectedColumn-1].getIsEmpty()) {
                    System.out.println("\nERROR - This cell is empty !");
                    success = 3;
                } else {
                    if ( currentPlayer.getColor() != board[selectedRow-1][selectedColumn-1].getCurrentPiece().getColor()) {
                        System.out.println("\nERROR - This cell contains a piece that is not yours !");
                        success = 3;
                    } else {
                        condB1 = 1;
                    }
                }
            }
            while (condB2 == 0) {
                expectedRow = inputParser.askIntUser("\n- Enter the row of the cell where you want to move : ");
                while (condD == 0) {
                    if (expectedRow <= 8 && expectedRow >= 1) {
                        condD = 1;
                    } else {
                        System.out.println("\nERROR !");
                        expectedRow = inputParser.askIntUser("\n- Enter the row of the cell where you want to move : ");
                    }
                }
                expectedColumn = inputParser.askColumnUser("\n- Enter the column of the cell where you want to move : ");
                if (!board[expectedRow-1][expectedColumn-1].getIsEmpty()) {
                    if ( currentPlayer.getColor() == board[expectedRow-1][expectedColumn-1].getCurrentPiece().getColor()) {
                        System.out.println("\nERROR - This cell contains a piece that is yours !");
                    } else {
                        if (board[selectedRow-1][selectedColumn-1].getCurrentPiece().isValidToMove(expectedRow, expectedColumn, board)){
                            System.out.println("\nYour move has been validated !");
                            board[expectedRow-1][expectedColumn-1].setCurrentPiece(board[selectedRow-1][selectedColumn-1].getCurrentPiece());
                            board[expectedRow-1][expectedColumn-1].getCurrentPiece().setPosition(new Position(expectedColumn, expectedRow));
                            board[expectedRow-1][expectedColumn-1].getCurrentPiece().setMoved();
                            board[selectedRow-1][selectedColumn-1].setCurrentPiece(null);
                            printBoard();
                            condB2 = 1;
                            int nbOfKinks = 0;
                            for (int r = 0; r < 8; r++) {
                                for (int c = 0; c < 8; c++) {
                                    if (board[r][c].getCurrentPiece() != null && Objects.equals(board[r][c].getCurrentPiece().toString(), "K"))
                                        nbOfKinks++;
                                }
                            }
                            if (nbOfKinks == 1){
                                success = 4;
                            } else {
                                success = 2;
                            }
                        } else {
                            System.out.println("\nYour move has not been validated !");
                            condB2 = 1;
                            success = 1;
                        }
                    }
                } else {
                    if (board[selectedRow-1][selectedColumn-1].getCurrentPiece().isValidToMove(expectedRow, expectedColumn, board)){
                        System.out.println("\nYour move has been validated !");
                        board[expectedRow-1][expectedColumn-1].setCurrentPiece(board[selectedRow-1][selectedColumn-1].getCurrentPiece());
                        board[expectedRow-1][expectedColumn-1].getCurrentPiece().setPosition(new Position(expectedColumn, expectedRow));
                        board[expectedRow-1][expectedColumn-1].getCurrentPiece().setMoved();
                        board[selectedRow-1][selectedColumn-1].setCurrentPiece(null);
                        printBoard();
                        condB2 = 1;
                        int nbOfKinks = 0;
                        for (int r = 0; r < 8; r++) {
                            for (int c = 0; c < 8; c++) {
                                if (board[r][c].getCurrentPiece() != null && Objects.equals(board[r][c].getCurrentPiece().toString(), "K"))
                                    nbOfKinks++;
                            }
                        }
                        if (nbOfKinks == 1){
                            success = 4;
                        } else {
                            success = 2;
                        }
                    } else {
                        System.out.println("\nYour move has not been validated !");
                        condB2 = 1;
                        success = 1;

                    }
                }
            }

            condB1 = 0;
            condB2 = 0;
            if (success == 2){
                if (Objects.equals(currentPlayer.getName(), players[0].getName())) {
                    currentPlayer = players[1];
                } else {
                    currentPlayer = players[0];
                }
            }

        }
    }

}