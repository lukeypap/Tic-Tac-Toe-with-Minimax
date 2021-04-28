package com.company;

import java.util.Random;

public class EasyAi implements Player {

    private final char mark;
    private Random rand;
    private int row;
    private int col;
    private final String name = "AI";
    private final String difficulty = "easy";

    public void setMove(Board board) {
        rand = new Random();
        row = rand.nextInt(4 - 1) + 1;
        col = rand.nextInt(4 - 1) + 1;
    }

    public EasyAi(char mark) {
        this.mark = mark;
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

    public void analyze(Board board) {

    }
}
