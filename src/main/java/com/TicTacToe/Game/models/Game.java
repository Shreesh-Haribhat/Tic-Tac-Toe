package com.TicTacToe.Game.models;

import com.TicTacToe.Game.stratergy.WinningStrategy.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class Game {
    private List<Player> playerList;
    private Board board;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private int nextPlayerIndex;
    List<WinningStrategy> winningStrategyList;

    private Game(int dimension, List<Player> playerList, List<WinningStrategy> winningStrategyList){
        this.board = new Board(dimension);
        this.playerList = playerList;
        this.winningStrategyList = winningStrategyList;

        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerIndex = 0;

    }

    public void displayBoard(){
        this.board.displayBoard();
    }

    public void makeMove(){
        Player currentPlayer = playerList.get(nextPlayerIndex);

        System.out.println("It is "+currentPlayer.getName() +"'s turn");

        Move move = currentPlayer.makeMove(this.board);
        System.out.println(currentPlayer.getName() + " has made a move at row = "+move.getCell().getRow()+" and col= "+move.getCell().getCol());

        if(!validateBoard(move))
        {
            return;
        }
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell actualCellOnBoard = board.getBoard().get(row).get(col);
        actualCellOnBoard.setCellState(CellState.OCCUPIED);
        actualCellOnBoard.setPlayer(currentPlayer);

        Move actualMove = new Move(actualCellOnBoard,currentPlayer);
        moves.add(actualMove);

        nextPlayerIndex += 1;
        nextPlayerIndex %= playerList.size();

        if(checkWinner(actualMove))
        {
            setGameState(GameState.COMPLETED);
            setWinner(currentPlayer);
        }

        if(moves.size() == board.getSize() * board.getSize())
        {
            setGameState(GameState.DRAW);
            System.out.println("Game DRAWNNNNNN !!");
        }
    }

    public boolean checkWinner(Move move)
    {
        for(WinningStrategy winningStrategy : winningStrategyList)
        {
            if(winningStrategy.checkWinner(board,move))
            {
                return true;
            }
        }
        return false;
    }

    public boolean validateBoard(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row < 0 || row >= board.getSize())
        {
            return false;
        }

        if(col < 0 || col>= board.getSize())
        {
            return false;
        }

        if(board.getBoard().get(row).get(col).equals(CellState.OCCUPIED))
        {
            return false;
        }

        return true;
    }


    public static Builder getBuilder(){
        return new Builder();
    }


    public static class Builder{
        private int dimension;
        private List<Player> playerList;
        List<WinningStrategy> winningStrategyList;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayerList(List<Player> playerList) {
            this.playerList = playerList;
            return this;
        }

        public Builder setWinningStrategyList(List<WinningStrategy> winningStrategyList) {
            this.winningStrategyList = winningStrategyList;
            return this;
        }

        public Game build(){
            validate();
            return new Game(dimension,playerList,winningStrategyList);
        }

        private void validate() {
            validateBotCount();
            validatePlayerCount();
            validateSymbolCount();
        }

        private void validatePlayerCount(){
            if(playerList.size() != dimension-1){
                throw new RuntimeException();
            }

        }
        private void validateBotCount(){
            int bots = 0;
            for(Player p : playerList){
                if(p.getPlayerType().equals(PlayerType.BOT)){
                    bots++;
                }
            }
            if(bots > 1){
                throw new RuntimeException();
            }

        }
        private void validateSymbolCount(){
            Map<Character,Integer> hm = new HashMap<>();
            for(Player p : playerList){
                if(hm.containsKey(p.getSymbol().getSymbol())){
                    throw new RuntimeException();
                }
                else{
                    hm.put(p.getSymbol().getSymbol(), 1);
                }
            }

        }
    }
}
