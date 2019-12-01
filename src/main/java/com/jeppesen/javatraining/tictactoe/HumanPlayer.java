package com.jeppesen.javatraining.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer implements Player { // change to interface and create two classes Human player and Computer player and add to git


    public Position requestMove(){

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.printf(" \nInsert x and y for empty field:\n ");
            String line = reader.readLine();
            String[] items = line.split(" ", 3);
            Position position = new Position(Integer.parseInt(items[0]), Integer.parseInt(items[1]));
            return position;
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }


}
