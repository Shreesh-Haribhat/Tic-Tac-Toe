package com.TicTacToe.Game.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private Player player;

    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        this.cellState = CellState.EMPTY;

    }
}
