package com.jeppesen.javatraining.tictactoe;

import static com.jeppesen.javatraining.tictactoe.GameLogic.checkIfFieldIsEmpty;

public class ComputerPlayer implements Player { // change to interface and create two classes Human player and Computer player and add to git


    public Position requestMove() {

        System.out.printf(" \nComputer says:\n ");

      //  GameLogic gameLogic = new GameLogic();
        Position positionOutput = new Position();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                Position position = new Position(i, j);

                if (checkIfFieldIsEmpty(position)) {
                    positionOutput = position;
                } else {
                    continue;
                }
            }
        }
        return positionOutput;

    }


}
