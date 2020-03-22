package com.sudoku;

public class MatrixPos {
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    int row;
    int col;

    public MatrixPos(int row, int col) {
        this.row = row;
        this.col = col;
    }


}
