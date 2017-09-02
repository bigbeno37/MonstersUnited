package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// The instance that hosts the board itself. It contains all
// current BoardPieces that occupy the board, and contain
// convenience methods such as getPieceAt and setPieceAt
// to help development
public class Board implements Serializable{
    private BoardPiece[][] board;
    private List<Player> players;
    private Monster monster;

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public int getAmountOfPlayers() {
        return this.players.size();
    }

    public Monster getMonster() {
        return monster;
    }

    public Board() {
        board = new BoardPiece[9][9];
        players = new ArrayList<>();
        monster = new Monster(5,5);
        // TODO
        // Initialise the board to include walls
    }

    public BoardPiece[][] getBoard() {
        return board;
    }

    private void setBoard(BoardPiece[][] board) {
        this.board = board;
    }

    private void setPieceAt(int x, int y, BoardPiece pieceToBePlaced) {
        this.board[y][x] = pieceToBePlaced;
    }
    
    public BoardPiece getPieceAt(int x, int y) {
        return this.board[y][x];
    }

    public void update() {
        // TODO
        // Parse through players and update their positions on this board
        // as well as the monster
    }
}
