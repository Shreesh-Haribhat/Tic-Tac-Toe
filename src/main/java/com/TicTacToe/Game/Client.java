package com.TicTacToe.Game;

import com.TicTacToe.Game.controllers.GameController;
import com.TicTacToe.Game.models.*;
import com.TicTacToe.Game.stratergy.WinningStrategy.ColWinningStratergy;
import com.TicTacToe.Game.stratergy.WinningStrategy.DiagonalWinningStratergy;
import com.TicTacToe.Game.stratergy.WinningStrategy.RowWinningStratergy;
import com.TicTacToe.Game.stratergy.WinningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args){
        GameController gameController = new GameController();

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
                    gameController.makeMove(game);
            }
            System.out.println(game.getWinner().getName() + " Won the game0");
        }catch (Exception e){
            System.out.println("Something Went wrong "+ e.getMessage());
        }

        System.out.println("Game has been created");
    }
}