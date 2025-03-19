package com.TicTacToe.Game.models;

import com.TicTacToe.Game.Factory.BotPlayingStratergyFactory;
import com.TicTacToe.Game.stratergy.BotPlayingStratergy.BotPlayingStratergy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStratergy botPlayingStratergy;

    public Bot(int id,String name,PlayerType playerType,Symbol symbol,BotDifficultyLevel botDifficultyLevel){
        super(id,name,symbol,playerType);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStratergy = BotPlayingStratergyFactory.getBotPlayingStratergy(botDifficultyLevel);

    }

    public Move makeMove(Board board){
        return this.botPlayingStratergy.makeMove(board);
    }
}
