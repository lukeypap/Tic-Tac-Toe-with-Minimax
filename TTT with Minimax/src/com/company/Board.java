package com.company;

public class Board {

    private final char[][] board;

    public Board() {
        board = new char[3][3];
        initBoard(board);
        print(board);
    }

    public void print(char[][] board) {
        int count = 0;
        System.out.println("---------");
        for(int i = 0; i < 3; i++) {
            System.out.println("| " + board[i][count] + " " + board[i][count + 1] + " " + board[i][count + 2] + " |");
        }
        System.out.println("---------");
    }

    private void initBoard(char[][] board) {
        for(int i = 0; i < board[0].length; i ++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean place(int row, int col, char mark) {
        if(!checkOccupied(row, col)) {
            board[row - 1][col - 1] = mark;
            return false;
        } else {
            return true;
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean checkOccupied(int row, int col) {
        return board[row - 1][col - 1] != ' ';
    }
}
