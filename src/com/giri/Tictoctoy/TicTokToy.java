package com.giri.Tictoctoy;

import java.util.Scanner;

public class TicTokToy {
    static String print = "allow";
    static int count = 1;
    static int temp1=0;
    static int temp2 = 0;
    static int winnerCount = 0;
    static boolean con = false;
    static int winningcheck = 0;
    static boolean gamestatus = false;


        public static void main(String[] args) {
            char[][] game = createGame();
            printGame(game);
                switch (print) { //this condition using for once program win or draw dont active this case.
                    case "allow":
                            startGame(game);
                    case "Draw":
                        System.out.println("Draw");
                }
            }


        // start the game entry the coardinate in space place.
        private static void startGame(char[][] game) {
            if (count < 10) {
                int n = 0;
                int m = 0;
                System.out.print("Enter the coordinates: ");
                Scanner scanner1 = new Scanner(System.in);
                try {
                    n = scanner1.nextInt() - 1; // nextInt method using for user integer value send in to the project.
                    m = scanner1.nextInt() - 1;
                } catch (Exception e) {
                    System.out.println("You should enter numbers!");
                    startGame(game);
                }
                entryGame(game, n, m);
            } else {
                print = "Draw";
            }
        }


        // this method impliment for the if we understand the int value check;
        private static void entryGame(char[][] game,int n,int m) {
            if((n>=0 && n < game.length) && (m >= 0 && m < game.length)) {
                checkingGame(game, n, m);
            } else {
                System.out.println("Coordinates should be from 1 to 3!");
                startGame(game);
            }
        }

        // checking game and put x first and then o.
        private static void checkingGame(char[][] game, int n, int m) {
            if (game[n][m] != 'X' && game[n][m] != 'O') { //  index space or value their checking in their.
                if (count % 2 != 0) {    // in odd value entry the x else entry the o
                    game[n][m] = 'X';
                    count++;//becuase next print O
                } else {
                    game[n][m] = 'O';
                    count++; //because next print x
                }
                temp1 = n;
                temp2 = m;
                printGame(game); //once u entry the value once again print.
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                startGame(game); // else start the program.
            }
        }

    // using this method for the print the game string.
        private static void printGame(char[][] game) {
                System.out.println("---------");
                StringBuilder printword = new StringBuilder("");
                for (int i = 0; i < 3; i++) {
                    printword.append("|"); // .append method using in the StingBuilder  for add string.
                    for (int j = 0; j < 3; j++) {
                        if (game[i][j] != '_') {  // check the game char == '_' replace the ' ' space
                            printword.append(" ").append(game[i][j]);
                        } else {
                            printword.append(" ").append(" "); //  here replace the '_' underscore to ' ' space
                        }
                    }
                    if (i == 2) {
                        printword.append(" |");
                        break;
                    }
                    printword.append(" |\n");
                }
                System.out.println(printword);
                System.out.println("---------");
                    gameLooping(game);
            }

            //after input print entry the game looping method this is entry the new value.
    private static void gameLooping(char[][] game) {
        if (!gamestatus && winningcheck != 1) { //13 12 21 22 23 31 32 33 11
                checkWinCondition(game, temp1, temp2);
                    if (!gamestatus) {
                        if (winningcheck != 1) {
                            startGame(game);
                        } else {
                            System.out.println(game[temp1][temp2] + " wins");
                            gamestatus = true;
                            print = "disable";
                        }
                    } else {
                        System.out.println("Draw");
                }
            }
        }

    //who win condition this method we have use.
        private static void checkWinCondition(char[][] game, int n, int m) {
        char winner = game[n][m];
        if (winner == 'X' || winner == 'O') {
            whoWin(game,winner,n,m);
        }
        }


    // This method using for the winning condition who win or draw this is codition
    private static void whoWin(char[][] game,char winner,int n,int m) {
           if (game[n][m] == game[0][0] && game[n][m] == game[0][1]  && game[n][m] == game[0][2]) {
                winningcheck = 1; // up codition check. == ok
            }
           if (game[n][m] == game[0][0] && game[n][m] == game[1][0]  && game[n][m] == game[2][0]) {
                winningcheck = 1; // left side codition check.== ok
            }
           if (game[n][m] == game[2][0] && game[n][m] == game[2][1]  && game[n][m] == game[2][2] ) {
               winningcheck = 1; // down side check. == ok
           }
           if (game[n][m] == game[0][2] && game[n][m] == game[1][2]  && game[n][m] == game[2][2] ) {
               winningcheck = 1; // this check is right side == ok
           }
           if (game[n][m] == game[1][0] && game[n][m] == game[1][1]  && game[n][m] == game[1][2] ) {
               winningcheck = 1; // this checking is middle left to right == ok
           }
           if (game[n][m] == game[0][0] && game[n][m] == game[1][1]  && game[n][m] == game[2][2] ) {
               winningcheck = 1; //  '\'top to bottom left side to right side == ok
           }
           if (game[n][m] == game[2][0] && game[n][m] == game[1][1]  && game[n][m] == game[0][2]) {
               winningcheck = 1; //ok '/' top to bottom right to left == ok
           }
           if (game[n][m] == game[0][1] && game[n][m] == game[1][1]  && game[n][m] == game[2][1] ) {
               winningcheck = 1; // this is middle top to bottom.  == ok
           }
    }

    //enter the new String and some space String put here using nextLine() method.
        private static char[][] createGame() {
            Scanner scanner = new Scanner(System.in);
            int position = 0;
            char[][] game = new char[3][3];
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    game[i][j] = ' '; //take single character from input String to the game index.
                    position++; //increment the position of the input char.
                }
            }
            return game;
        }
    }
