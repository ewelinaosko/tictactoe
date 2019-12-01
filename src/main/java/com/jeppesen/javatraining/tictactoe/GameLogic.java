package com.jeppesen.javatraining.tictactoe;

import java.io.IOException;

public class GameLogic {

  private Player player1 = new HumanPlayer();
  private Player player2 = new ComputerPlayer();
  private static Board board = new Board();

  public static boolean checkIfFieldIsEmpty(Position position) {
    return board.getCell(position.getX(), position.getY()) == FieldValue.EMPTY;
  }

  private void executeMove(Player player, FieldValue value) throws IOException {
    Position position;
    do {
      position = player.requestMove();
    } while (!checkIfFieldIsEmpty(position));
    board.setCell(position.getX(), position.getY(), value);
  }

  public void print() {

    System.out.println("x\\y| 0 | 1 | 2 |");
    System.out.println(" ----------------");
    System.out.println(
        "  0 | "
            + board.getCell(0, 0).getFieldValue()
            + " | "
            + board.getCell(0, 1).getFieldValue()
            + " | "
            + board.getCell(0, 2).getFieldValue()
            + " |");
    System.out.println(" ----------------");
    System.out.println(
        "  1 | "
            + board.getCell(1, 0).getFieldValue()
            + " | "
            + board.getCell(1, 1).getFieldValue()
            + " | "
            + board.getCell(1, 2).getFieldValue()
            + " |");
    System.out.println(" ----------------");
    System.out.println(
        "  2 | "
            + board.getCell(2, 0).getFieldValue()
            + " | "
            + board.getCell(2, 1).getFieldValue()
            + " | "
            + board.getCell(2, 2).getFieldValue()
            + " |");
    System.out.println(" ----------------");
  }

  public boolean winnerCheck() {

    boolean gameFinished = false;

    int counter0x;
    int counterXx;
    int counter0y;
    int counterXy;
    int counter0xy = 0;
    int counterXxy = 0;
    int counter0yx = 0;
    int counterXyx = 0;

    for (int x = 0; x < 3; x++) {

      counter0y = 0;
      counterXy = 0;

      for (int y = 0; y < 3; y++) {

        if (board.getCell(x, y).getFieldValue() == "O") {
          counter0y++;
        }
        if (board.getCell(x, y).getFieldValue() == "X") {
          counterXy++;
        }
        if (board.getCell(x, y).getFieldValue() == "O" && x == y) {
          counter0yx++;
        }
        if (board.getCell(x, y).getFieldValue() == "X" && x == y) {
          counterXyx++;
        }
        if (counter0y == 3 || counterXy == 3) {
          System.out.println(">>> We have a winner! <<<");
          gameFinished = true;
          break;
        }
      }
      if (counter0yx == 3 || counterXyx == 3) {
        System.out.println(">>> We have a winner! <<<");
        gameFinished = true;
        break;
      }
    }

    for (int y = 0; y < 3; y++) {

      counter0x = 0;
      counterXx = 0;

      for (int x = 0; x < 3; x++) {

        if (board.getCell(x, y).getFieldValue() == "O") {
          counter0x++;
        }
        if (board.getCell(x, y).getFieldValue() == "X") {
          counterXx++;
        }
        if (board.getCell(x, y).getFieldValue() == "O" && y == 2 - x) {
          counter0xy++;
        }
        if (board.getCell(x, y).getFieldValue() == "X" && y == 2 - x) {
          counterXxy++;
        }
        if (counter0x == 3 || counterXx == 3) {
          System.out.println(">>> We have a winner! <<<");
          gameFinished = true;
          break;
        }
      }
      if (counter0xy == 3 || counterXxy == 3) {
        System.out.println(">>> We have a winner! <<<");
        gameFinished = true;
        break;
      }
    }
    return gameFinished;
  }

  public void executeGame() throws IOException {

    System.out.println(" x\\y| 0 | 1 | 2 |");
    System.out.println(" ----------------");
    System.out.println("  0 |   |   |   |");
    System.out.println(" ----------------");
    System.out.println("  1 |   |   | X |");
    System.out.println(" ----------------");
    System.out.println("  2 |   |   |   |");
    System.out.println(" ----------------");

    System.out.println(" input format: x y, eg:");
    System.out.println(" 1 2 ");

    int moveNumber = 1;
    while (moveNumber <= 9) {
      System.out.println(" \n> Move: " + moveNumber + ", player1 <");
      executeMove(player1, FieldValue.PLAYER1);
      moveNumber++;
      print();
      if (winnerCheck()) {
        break;
      }

      System.out.println(" \n> Move: " + moveNumber + ", player2 <");
      executeMove(player2, FieldValue.PLAYER2);
      moveNumber++;
      print();
      if (winnerCheck()) {
        break;
      }

    }
  }

}
