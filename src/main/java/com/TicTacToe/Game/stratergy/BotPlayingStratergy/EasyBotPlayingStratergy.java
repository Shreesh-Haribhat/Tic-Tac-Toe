package com.TicTacToe.Game.stratergy.BotPlayingStratergy;

import com.TicTacToe.Game.models.Board;
import com.TicTacToe.Game.models.Cell;
import com.TicTacToe.Game.models.CellState;
import com.TicTacToe.Game.models.Move;

import java.util.List;

public class EasyBotPlayingStratergy implements BotPlayingStratergy{
    @Override
    public Move makeMove(Board board) {

        for(List<Cell> row : board.getBoard()){
            for(Cell cell : row)
            {
                if(cell.getCellState().equals(CellState.EMPTY))
                {
                    return new Move(cell, null);
                }
            }
        }
        return null;
    }
}
