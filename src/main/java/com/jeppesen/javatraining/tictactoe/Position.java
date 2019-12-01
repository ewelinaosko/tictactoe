package com.jeppesen.javatraining.tictactoe;

public class Position {

    private int x;
    private int y;

    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public Position() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
