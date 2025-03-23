package com.TicTacToe.Game.stratergy.WinningStrategy;

import com.TicTacToe.Game.models.Board;
import com.TicTacToe.Game.models.Move;

public interface WinningStrategy {

    public boolean checkWinner(Board board, Move move);

    public void undo(Board board, Move lastMove);
}
