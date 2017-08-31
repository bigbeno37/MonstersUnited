package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;
import java.util.List;

public class Board implements Serializable{
    private BoardPiece[][] board;

    public Board() {
        board = new BoardPiece[9][9];
        // TODO
        // Initialise the board to include walls
    }

    public BoardPiece[][] getBoard() {
        return board;
    }

    public void setBoard(BoardPiece[][] board) {
        this.board = board;
    }

    public void setPieceAt(int x, int y, BoardPiece pieceToBePlaced) {
        this.board[y][x] = pieceToBePlaced;
    }
    
    public BoardPiece getPieceAt(int x, int y) {
        return this.board[y][x];
    }

    public void update(List<Player> players, Monster monster) {
        // TODO
        // Parse through players and update their positions on this board
        // as well as the monster
    }
}
