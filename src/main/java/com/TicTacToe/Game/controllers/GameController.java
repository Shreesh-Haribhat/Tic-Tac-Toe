package com.TicTacToe.Game.controllers;

import com.TicTacToe.Game.models.*;
import com.TicTacToe.Game.stratergy.WinningStrategy.WinningStrategy;

import java.util.List;

public class GameController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
       return Game.getBuilder()
                .setDimension(dimension)
                .setPlayerList(players)
                .setWinningStrategyList(winningStrategies)
                .build();
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public void undo(){

    }

    public void checkState(){

    }

    public void getWinner(){

    }

    public void displayBoard(Game game){
            game.displayBoard();
    }
}
