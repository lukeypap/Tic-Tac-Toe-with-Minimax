package com.company;

public interface Player {

    char getMark();
    void setMove(Board board);
    int getRow();
    int getCol();
    String getName();
    String getDifficulty();
}
