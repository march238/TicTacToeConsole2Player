package com.march238;

import java.util.Scanner;

public class Game {
    private Board table;
    private Seed currentPlayer;
    private GameState currentState;

    private static Scanner scanner = new Scanner(System.in);

    //the whole game
    public Game(){
        this.table = new Board();       //allocate game table

        //initialize table
        initializeGame();

        while (currentState==GameState.PLAYING){
            playerMove(currentPlayer);
            update(currentPlayer);
            table.paint();

            if (this.currentState==GameState.CROSS_WON){
                System.out.println("Cross has won the game! Bye!");
            } else if (this.currentState == GameState.NOUGHT_WON){
                System.out.println("Nought has won the game! Bye!");
            } else if (this.currentState == GameState.DRAW){
                System.out.println("Draw! Game ended, Bye");
            }

            currentPlayer = currentPlayer==Seed.CROSS ? Seed.NOUGHT : Seed.CROSS;
        }

    }



    //initialize game
    public void initializeGame(){
        this.currentState=GameState.PLAYING;
        this.currentPlayer=Seed.CROSS;      // always cross starting the game
        table.init();
    }

    //player moves
    public void playerMove(Seed theSeed){
        boolean validInput = false;

        do {
            if (theSeed == Seed.CROSS){
                System.out.println("Cross enter your move(row[1-3] col[1-3]):");
            }else {
                System.out.println("Nought enter your move(row[1-3] col[1-3]):");
            }

            int row = scanner.nextInt()-1;
            int col = scanner.nextInt()-1;

            if (row>=0 && row<=Board.rows && col>=0 && col<=Board.cols && table.board[row][col].content == Seed.EMPTY){
                table.board[row][col].content=theSeed;
                table.currentRow=row;
                table.currentCol=col;
                validInput=true;
            }else {
                System.out.println("This move row: " + row+1 +" col: " + col+1 + " is invalid. Try again!");
            }
        }while (!validInput);
    }


    // update current state of the game
    public void update(Seed theSeed){
        if (table.hasWon(theSeed)){                         // checking if any has won
            if (theSeed == Seed.CROSS){                     // chechs if cross has won
                this.currentState=GameState.CROSS_WON;
            }else {
                this.currentState=GameState.NOUGHT_WON;     // if not cross won then nought
            }
        } else if (table.isDraw()){                         //check is it a drawn?
            this.currentState=GameState.DRAW;
        }
    }
}
