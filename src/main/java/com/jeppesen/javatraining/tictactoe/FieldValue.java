package com.jeppesen.javatraining.tictactoe;

public enum FieldValue {
    EMPTY(" "),
    PLAYER1("O"),
    PLAYER2("X");

    private final String fieldValue;

    FieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldValue() {
        return fieldValue;
    }

}
