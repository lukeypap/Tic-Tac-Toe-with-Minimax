package com.company;

import java.util.Scanner;

public class Menu {

    private Scanner in = new Scanner(System.in);
    private String[] menuArgs;
    private Player player1;
    private Player player2;

    private void menu() {
        System.out.println("Type help to see a list of commands");
        System.out.print("> ");
        menuArgs = in.nextLine().split(" ");
        if ("exit".equals(menuArgs[0])) {
            System.exit(0);
        } else if("help".equals(menuArgs[0])) {
            System.out.println("The input takes 3 arguments with a space between: " +
                    "\naction player1 player2\nPlayer 1 will start as X and player 2 will start as O" +
                    "\nList of players: user, easy, medium, hard\n" +
                    "EasyAI: Makes random moves, shouldn't be too hard to beat!\n" +
                    "MediumAI: Plays a little smarter but can only see one move in the future!\n" +
                    "HardAI: Unbeatable!\n" +
                    "List of actions: start, exit\n" +
                    "Example command: start user hard (Starts the game with a human player vs the hard AI)\n" +
                    "------------------------------------------------------------------");
            menu();
        } else if (menuArgs.length != 3){
            System.out.println("Bad Parameters!");
            menu();
        } else if ("start".equals(menuArgs[0])) {
            setUsers();
        }
    }

    private void setUsers() {
        setHuman();
        setEasyAi();
        setMedAi();
        setHardAi();
    }

    private void setHuman() {
        if ("user".equals(menuArgs[1])) {
            player1 = new Human('X');
        } if ("user".equals(menuArgs[2])) {
            player2 = new Human('O');
        }
    }

    private void setEasyAi() {
        if ("easy".equals(menuArgs[1])) {
            player1 = new EasyAi('X');
        } if ("easy".equals(menuArgs[2])) {
            player2 = new EasyAi('O');
        }
    }

    private void setMedAi() {
        if ("medium".equals(menuArgs[1])) {
            player1 = new MediumAi('X');
        } if ("medium".equals(menuArgs[2])) {
            player2 = new MediumAi('O');
        }
    }

    private void setHardAi() {
        if ("hard".equals(menuArgs[1])) {
            player1 = new MiniMax('X');
        } if ("hard".equals(menuArgs[2])) {
            player2 = new MiniMax('O');
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void run() {
        menu();
    }
}
