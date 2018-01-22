package com.march238;

public class Board {
    public static final int rows=3;     // num of rows of the table
    public static final int cols=3;     // num of cols of the table

    public Cell[][] board;              // table 2D array
    public int currentRow, currentCol;  // currently used cell location

    // constructor to initialize/create table
    public Board(){
        board = new Cell[rows][cols];               // create a new array for the cells
        for (int r = 0; r < rows; r++) {            // loop through the rows indexes
            for (int c = 0; c < cols; c++) {        // loop through the cols indexes
                board[r][c] = new Cell(r,c);        // add a new cell object to the board
            }
        }
    }

    // initialize or re-initialize table
    public void init(){
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                board[r][c].clear();
            }
        }
    }

    //returns true if the game is draw >> there are no empty cells
    public boolean isDraw(){
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c].content==Seed.EMPTY){
                    return false;                       // if an empty cell is found, its not a draw
                }
            }
        }
        return false;                                   // if empty cell haven't found, its a draw
    }

    public boolean hasWon(Seed theSeed){
        return (board[currentRow][0].content == theSeed    &&          // 3 in a current row
                board[currentRow][1].content == theSeed    &&
                board[currentRow][2].content == theSeed
                ||
                board[0][currentCol].content == theSeed    &&          // 3 in a current col
                board[1][currentCol].content == theSeed    &&
                board[2][currentCol].content == theSeed
                ||
                board[0][0].content == theSeed    &&          // 3 in diagonal
                board[1][1].content == theSeed    &&
                board[2][2].content == theSeed
                ||
                board[0][2].content == theSeed    &&          // 3 in opposite diagonal
                board[1][1].content == theSeed    &&
                board[2][0].content == theSeed
            );
    }

    public void paint(){                    // printing the table
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                board[r][c].paint();
                if (c+1<cols){
                    System.out.print("|");
                }
            }
            System.out.println();
            if (r+1<rows){
                System.out.print("-----------");
            }
            System.out.println();
        }
    }
}
