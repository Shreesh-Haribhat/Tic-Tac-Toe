package com.TicTacToe.Game;

import com.TicTacToe.Game.controllers.GameController;
import com.TicTacToe.Game.models.*;
import com.TicTacToe.Game.stratergy.WinningStrategy.ColWinningStratergy;
import com.TicTacToe.Game.stratergy.WinningStrategy.DiagonalWinningStratergy;
import com.TicTacToe.Game.stratergy.WinningStrategy.RowWinningStratergy;
import com.TicTacToe.Game.stratergy.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){
        GameController gameController = new GameController();
        Scanner scn = new Scanner(System.in);

        try {
            int dimension = 3;
            List<Player> players = new ArrayList<>();
            players.add(new Player(1,"Shreesh",new Symbol('X'), PlayerType.HUMAN));
            players.add(new Bot(2,"Haribhat",PlayerType.BOT,new Symbol('O'),BotDifficultyLevel.EASY));
            List<WinningStrategy> winningStrategies = new ArrayList<>();
            winningStrategies.add(new ColWinningStratergy());
            winningStrategies.add(new DiagonalWinningStratergy());
            winningStrategies.add(new RowWinningStratergy());

            Game game = gameController.startGame(3, players, winningStrategies);

            while(game.getGameState().equals(GameState.IN_PROGRESS)){
                    gameController.displayBoard(game);

                    System.out.println("Do u want to undo the game (y/n): ");
                    String ans = scn.next();
                    if(ans.equalsIgnoreCase("y")){
                        gameController.undo(game);
                    }

                    gameController.makeMove(game);
            }

            if(gameController.checkState(game).equals(GameState.DRAW)){
                System.out.println("Game has been drawn");
            }

            System.out.println(game.getWinner().getName() + " Won the game");
        }catch (Exception e){
            System.out.println("Something Went wrong "+ e.getMessage());
        }

    }
}