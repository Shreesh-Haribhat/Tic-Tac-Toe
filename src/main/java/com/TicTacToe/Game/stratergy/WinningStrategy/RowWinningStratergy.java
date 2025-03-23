package com.TicTacToe.Game.stratergy.WinningStrategy;

import com.TicTacToe.Game.models.Board;
import com.TicTacToe.Game.models.Move;
import com.TicTacToe.Game.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStratergy implements WinningStrategy{

    Map<Integer, Map<Symbol,Integer>> rowMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        Symbol symbol = move.getPlayer().getSymbol();
        if(!rowMap.containsKey(row))
        {
            rowMap.put(row,new HashMap<>());
        }
        Map<Symbol,Integer> singleRowMap = rowMap.get(row);
        if(!singleRowMap.containsKey(symbol))
        {
            singleRowMap.put(symbol,0);
        }
        singleRowMap.put(symbol,singleRowMap.get(symbol) + 1);
        if(singleRowMap.get(symbol).equals(board.getSize()))
        {
            return true;
        }
        return false;
    }

    @Override
    public void undo(Board board, Move lastMove) {
        int row = lastMove.getCell().getCol();
        Symbol symbol = lastMove.getPlayer().getSymbol();
        Map<Symbol,Integer> singleRowMap = rowMap.get(row);

        singleRowMap.put(symbol,singleRowMap.get(symbol) - 1);
    }
}
