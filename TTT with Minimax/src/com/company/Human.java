package com.company;

import java.util.Scanner;

public class Human implements Player {

    private final char mark;
    private Scanner in;
    private int row;
    private int col;
    private int pos;

    public Human(char mark) {
        this.mark = mark;
    }

    public char getMark() {
        return mark;
    }

    public void setMove(Board board) {
        in = new Scanner(System.in);
        System.out.print("Enter your move: ");
        try {
            pos = in.nextInt();
            setRowCol(pos);
        } catch(Exception e) {
            System.out.println("You should enter numbers!");
            setMove(board);
        }
        if(row > 3 || col > 3 || row < 1 || col < 1) {
            System.out.println("Coordinates should be from 1 to 3!");
            setMove(board);
        }
    }

    private void setRowCol(int pos) {
        row = ((pos - 1) / 3) + 1;
        col = ((pos - 1) % 3) + 1;
    }


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String getName() {
        return " ";
    }

    @Override
    public String getDifficulty() {
        return null;
    }
}
