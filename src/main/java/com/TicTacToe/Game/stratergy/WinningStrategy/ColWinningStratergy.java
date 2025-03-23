package com.TicTacToe.Game.stratergy.WinningStrategy;

import com.TicTacToe.Game.models.Board;
import com.TicTacToe.Game.models.Move;
import com.TicTacToe.Game.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStratergy implements WinningStrategy{
    Map<Integer, Map<Symbol,Integer>> colMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();
        if(!colMap.containsKey(col))
        {
            colMap.put(col,new HashMap<>());
        }
        Map<Symbol,Integer> singleColMap = colMap.get(col);
        if(!singleColMap.containsKey(symbol))
        {
            singleColMap.put(symbol,0);
        }
        singleColMap.put(symbol,singleColMap.get(symbol) + 1);
        return singleColMap.get(symbol).equals(board.getSize());
    }

    @Override
    public void undo(Board board, Move lastMove) {
        int col = lastMove.getCell().getCol();
        Symbol symbol = lastMove.getPlayer().getSymbol();
        Map<Symbol,Integer> singleColMap = colMap.get(col);

        singleColMap.put(symbol,singleColMap.get(symbol) - 1);
    }
}
