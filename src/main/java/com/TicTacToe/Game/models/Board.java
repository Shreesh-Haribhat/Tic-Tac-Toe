package com.TicTacToe.Game.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size){
        this.size = size;
        this.board = new ArrayList<>();

        for(int i=0;i<size;i++){
            board.add(new ArrayList<>());
            for(int j=0;j<size;j++){
                board.get(i).add(new Cell(i, j));
            }
        }

    }

    public void displayBoard(){
        for(List<Cell> row : this.getBoard())
        {
            for(Cell cell : row)
            {
                if(cell.getCellState().equals(CellState.EMPTY)){
                    System.out.print("| - |");
                }
                else {
                    System.out.print("| "+ cell.getPlayer().getSymbol().getSymbol()+ " |");
                }
            }
            System.out.println();
        }
    }
}
