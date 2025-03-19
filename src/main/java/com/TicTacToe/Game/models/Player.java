package com.TicTacToe.Game.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Setter
@Getter
public class Player {
    private String name;
    private int id;
    private Symbol symbol;
    private PlayerType playerType;

    public Player(int id, String name, Symbol symbol, PlayerType playerType){
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter row number: ");
        int row = scn.nextInt();
        System.out.println("Enter col number: ");
        int col = scn.nextInt();

        return new Move(new Cell(row, col), this);

    }
}
