package com.company;

public class Game {

    private Board board;
    //private States gameState;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Menu menu = new Menu();

    public Game() {
        while (true) {
            menu.run();
            gameLoop();
        }
    }

    private void gameLoop() {
        startGame();
        while(!checkState()) {
            placeMark();
            if(currentPlayer.getName().equals("AI")) {
                System.out.println("Making move level \"" + currentPlayer.getDifficulty() + "\"");
            }
            currentPlayer = switchPlayer();
            board.print(board.getBoard());
        }
    }

    private void startGame() {
        board = new Board();
        //gameState = new States();
        this.player1 = menu.getPlayer1();
        this.player2 = menu.getPlayer2();
        currentPlayer = player1;
    }

    private void placeMark() {
        currentPlayer.setMove(board);
        if (board.place(currentPlayer.getRow(), currentPlayer.getCol(), currentPlayer.getMark())) {
            if(!currentPlayer.getName().equals("AI")) {
                System.out.println("This cell is occupied! Choose another one!");
            }
            placeMark();
        }
    }

    private Player switchPlayer() {
        if(currentPlayer == player1) {
            return player2;
        } else {
            return player1;
        }
    }

    private boolean checkState() {
        if(States.checkWinner(board.getBoard())) {
            System.out.println(States.getWinner() + " wins");
            System.out.println("-------------------");
            return true;
        } else if(States.checkFull(board.getBoard())) {
            System.out.println("Draw");
            System.out.println("-------------------");
            return true;
        }
        return false;
    }
}
