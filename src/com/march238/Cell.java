package com.march238;

public class Cell {
    Seed content;
    int row, col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        clear();
    }

    public void clear(){
        content = Seed.EMPTY;
    }

    public void paint(){
        switch (content){
            case EMPTY:
                System.out.print("   ");
                break;
            case CROSS:
                System.out.print(" X ");
                break;
            case NOUGHT:
                System.out.print(" O ");
                break;
        }
    }

}
