package com.sda.problema.damelor;

public class Position {

    private int indexOfRow;
    private int indexOfColumn;

    public Position(int indexOfRow, int indexOfColumn) {
        this.indexOfRow = indexOfRow;
        this.indexOfColumn = indexOfColumn;
    }

    public Position() {
    }

    public int getIndexOfRow() {
        return indexOfRow;
    }

    public void setIndexOfRow(int indexOfRow) {
        this.indexOfRow = indexOfRow;
    }

    public int getIndexOfColumn() {
        return indexOfColumn;
    }

    public void setIndexOfColumn(int indexOfColumn) {
        this.indexOfColumn = indexOfColumn;
    }

    @Override
    public String toString() {
        return "(" + indexOfRow + "," + indexOfColumn + ")";
    }
}
