package com.TicTacToe.Game.models;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Symbol {
    private char symbol;

    public Symbol(char c){
        this.symbol = c;
    }
}
