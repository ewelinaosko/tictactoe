package com.jeppesen.javatraining.tictactoe;

public class Board {

    private FieldValue[][] gameBoard;


    public Board() {
        gameBoard = new FieldValue[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                gameBoard[i][j] = FieldValue.EMPTY;
            }
        }
    }


    public void setCell(int x, int y, FieldValue value) {
        gameBoard[x][y] = value;
    }

    public FieldValue getCell(int x, int y) {
        return gameBoard[x][y];
    }

}
