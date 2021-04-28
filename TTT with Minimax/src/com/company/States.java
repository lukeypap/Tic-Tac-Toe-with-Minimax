package com.company;

public final class States {

    private static char winner;

    private States() {

    }

    public static boolean checkWinner(char[][] board) {
        //Rows
        if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != ' ') { winner = board[0][0]; return true; }
        if(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != ' ') { winner = board[1][0]; return true; }
        if(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != ' ') { winner = board[2][0]; return true; }
        //Cols
        if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != ' ') { winner = board[0][0]; return true; }
        if(board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != ' ') { winner = board[0][1]; return true; }
        if(board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != ' ') { winner = board[0][2]; return true; }
        //Diags
        if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') { winner = board[0][0]; return true; }
        if(board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') { winner = board[0][2]; return true; }

        else {
            return false;
        }
    }

    public static boolean checkFull(char[][] board) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public static char getWinner() {
        return winner;
    }
}
