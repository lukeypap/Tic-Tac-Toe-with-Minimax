package com.company;

public class MiniMax implements Player {

    private final char mark;
    private int row;
    private int col;
    private final String name = "AI";
    private final String difficulty = "Hard";
    private char oppMark;
    private char[][] b;
    private int NumOfEndStates;

    MiniMax(char mark) {
        this.mark = mark;
        setOppenentMark(mark);
    }

    public void setMove(Board board) {
        NumOfEndStates = 0;                    //Tracking the number of end game positions searched.
        b = board.getBoard();               //Getting the current game board.
        findBestMove(b);                    //sending the board through the findBestMove function to find the best move.
        System.out.println("Number of possible end game states searched by the AI: " + NumOfEndStates);
        row++;
        col++;
    }

    private void findBestMove(char[][] board) {
        int bestEndMoveValue = -10;         //Initializing the bestValue as the worst outcome -10 - a loss.
        row = 0;                            //resetting the row and col
        col = 0;
        for(int i = 0; i < 3; i++) {        //Looping through all squares on the board until it finds a space
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == ' ') {
                    board[i][j] = mark;     //Setting the space == mark - the Ai's mark X or O.
                    int CurrentEndMoveValue = minimax(board, 0, false); //Setting the CurrentEndMoveValue equal to the best value of the minimax func passing in the board.
                    board[i][j] = ' ';      //Resetting the move we just made.
                    if(CurrentEndMoveValue > bestEndMoveValue) { //If the CurrentEndMoveValue is better than bestEndMoveValue then set the row and col equal to the move.
                        row = i;            //This will always be true for the first move. Since the the first search will return 0 - a draw.
                        col = j;
                        bestEndMoveValue = CurrentEndMoveValue;  //Setting the bestValue to equal the current highest CurrentEndMoveValue so the move isn't overwritten.
                    }
                }
            }
        }
    }

    private int evaluate(char[][] board) {  //Just checks if there is a winner
        if(States.checkWinner(board)) {
            if(States.getWinner() == mark) {
                return +10;                 //Returns the value of 10 for a win
            } else if(States.getWinner() == oppMark) {
                return -10;                 //Returns the value of -10 for a loss
            }
        }
        return 0;   //Returns 0 if neither are true;
    }

    private int minimax(char[][] board, int depth, boolean isMax) {
        int score = evaluate(board);        //Evaluates the current board.
        int best;
        if(score == 10 || score == -10) {   //If the evaluation returned an end state + 10 for win. - 10 for loss then return that score.
            NumOfEndStates++;               //Everytime it finds an end state it adds 1 to the endStates counter.
            return score;
        } else if(States.checkFull(board)) {
            NumOfEndStates++;
            return 0;                       //If the board is full return 0;
        }
        if(isMax) {                         //If no end state has been found we start looking for the next move. First isMax will be false as the first node is always the maximizer
            best = -10;                     //Setting the best at -10 the worst possible value and we will try maximise this value.
            for(int i = 0; i < 3; i++) {    //Looping through every square until we find a space
                for(int j = 0; j < 3; j++) {
                    if(board[i][j] == ' ') {
                        board[i][j] = mark;                                                //Placing our mark in the space
                        best = Math.max(best, minimax(board, depth+1, !isMax));     //Recursively calling the function until we find an end state which will take the highest value found from all possible end states.
                        board[i][j] = ' ';  //Undo our move.
                    }
                }
            }
        }
        else {              //Same for the maximizer except we're trying to find the lowest possible value.
            best = 10;
            for(int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = oppMark;
                        best = Math.min(best, minimax(board, depth + 1, !isMax)); //Depth here is used for future implementation of a depth limiter or we can see how deep the minimax searches.
                        board[i][j] = ' ';
                    }
                }
            }
        }
        return best;    //Returns the last best value which will be the value that ended the game for this node.
    }

    private char setOppenentMark(char mark) {
        if(mark == 'X') {
            return oppMark = 'O';
        } else {
            return oppMark = 'X';
        }
    }

    public int getRow() {
        return row;
    }

    public char getMark() {
        return mark;
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
