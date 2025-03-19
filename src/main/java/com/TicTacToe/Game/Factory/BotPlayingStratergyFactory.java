package com.TicTacToe.Game.Factory;

import com.TicTacToe.Game.models.BotDifficultyLevel;
import com.TicTacToe.Game.stratergy.BotPlayingStratergy.BotPlayingStratergy;
import com.TicTacToe.Game.stratergy.BotPlayingStratergy.EasyBotPlayingStratergy;
import com.TicTacToe.Game.stratergy.BotPlayingStratergy.HardBotPlayingStratergy;
import com.TicTacToe.Game.stratergy.BotPlayingStratergy.MediumBotPlayingStratergy;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BotPlayingStratergyFactory {

    public static BotPlayingStratergy getBotPlayingStratergy(BotDifficultyLevel botDifficultyLevel)
    {
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY))
        {
            return new EasyBotPlayingStratergy();
        }

        if(botDifficultyLevel.equals(BotDifficultyLevel.HARD))
        {
            return new HardBotPlayingStratergy();
        }

        if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM))
        {
            return new MediumBotPlayingStratergy();
        }

        return new EasyBotPlayingStratergy();
    }
}
