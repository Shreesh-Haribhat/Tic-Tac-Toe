package com.TicTacToe.Game.stratergy.WinningStrategy;

import com.TicTacToe.Game.models.Board;
import com.TicTacToe.Game.models.Move;

public class RowWinningStratergy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
