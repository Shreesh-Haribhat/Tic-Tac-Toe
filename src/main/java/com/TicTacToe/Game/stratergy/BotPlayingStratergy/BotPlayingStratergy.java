package com.TicTacToe.Game.stratergy.BotPlayingStratergy;

import com.TicTacToe.Game.models.Board;
import com.TicTacToe.Game.models.Move;

public interface BotPlayingStratergy {

    public Move makeMove(Board board);
}
