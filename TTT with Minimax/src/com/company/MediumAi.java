package com.company;

import java.util.Random;

public class MediumAi implements Player {

    //TODO: Find way to reverse logic and block.

    private final char mark;
    private Random rand;
    private int row;
    private int col;
    private final String name = "AI";
    private final String difficulty = "Medium";
    private char oppMark;

    public MediumAi(char mark) {
        this.mark = mark;
        setTempMark(mark);
    }

    public void setMove(Board board) {
        row = 0;
        col = 0;
        analyze(board.getBoard(), oppMark);
        analyze(board.getBoard(), mark);
        if (row == 0 && col == 0) {
            row = rand.nextInt(4 - 1) + 1;
            col = rand.nextInt(4 - 1) + 1;
        }
    }
    //Method check every possible value for each row to get co-ords. First checks wins then for blocks.
    //Need to revise and find better way to find terminal values.
    //Next step is to create methods like in original ttt and check for 2 chars and a space and return the row and col of the space
    //Just go through row/col/diag and if there's one ' ' then we save that coord
    //spaceCount = 0; if board[i][j] == ' ' spaceCount++; temprow tempcol = [i][j]  if spaceCount == 1 temprow tempcol = row col
    public void analyze(char [][] board, char mark) {
        rand = new Random();
        int count = 0;
        for(int i = 0; i < 3; i++) {
            //rows
            if(board[i][count] == mark && board[i][count+1] == mark && board[i][count+2] == ' ') { row = i + 1; col = count + 3; }
            if(board[i][count] == ' ' && board[i][count+1] == mark && board[i][count+2] == mark) { row = i + 1; col = count + 1; }
            if(board[i][count] == mark && board[i][count+1] == ' ' && board[i][count+2] == mark) { row = i + 1; col = count + 2; }
            //cols
            if(board[count][i] == mark && board[count+1][i] == mark && board[count+2][i] == ' ') { row = count + 3; col = i + 1; }
            if(board[count][i] == ' ' && board[count+1][i] == mark && board[count+2][i] == mark) { row = count + 1; col = i + 1; }
            if(board[count][i] == mark && board[count+1][i] == ' ' && board[count+2][i] == mark) { row = count + 2; col = i + 1; }
            //diag 1
            if(board[count][count] == mark && board[count+1][count+1] == mark && board[count+2][count+2] == ' ') { row = count + 3; col = count + 3; }
            if(board[count][count] == mark && board[count+1][count+1] == ' ' && board[count+2][count+2] == mark) { row = count + 2; col = count + 2; }
            if(board[count][count] == ' ' && board[count+1][count+1] == mark && board[count+2][count+2] == mark) { row = count + 1; col = count + 1; }
            //diag 2
            if(board[count][count+2] == mark && board[count+1][count+1] == mark && board[count+2][count] == ' ') { row = count + 3; col = count + 1; }
            if(board[count][count+2] == mark && board[count+1][count+1] == ' ' && board[count+2][count] == mark) { row = count + 2; col = count + 2; }
            if(board[count][count+2] == ' ' && board[count+1][count+1] == mark && board[count+2][count] == mark) { row = count + 1; col = count + 3; }
        }
    }

    private char setTempMark(char mark) {
        if(mark == 'X') {
            return oppMark = 'O';
        } else {
            return oppMark = 'X';
        }
    }

    public char getMark() {
        return mark;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public String getName() {
        return name;
    }

    public String getDifficulty() {
        return difficulty;
    }

}
