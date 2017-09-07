package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// The instance that hosts the board itself. It contains all
// current BoardPieces that occupy the board, and contain
// convenience methods such as getPieceAt and setPieceAt
// to help development
public class Board implements Serializable{
    private BoardPiece[][] board;
    private List<BoardPiece> boardPieces;

    public Board() {
        board = new BoardPiece[9][9];
        boardPieces = new ArrayList<>();
        boardPieces.add(new Monster(5,5));
        // TODO
        // Initialise the board to include walls
    }

    public List<Player> getPlayers() {
        return (List<Player>) filterByBoardPiece(Player.class);
    }

    // Go through the boardPieces list and return elements that match the
    // class that is passed in, eg. filterByBoardPiece(Player.class) will
    // return all Players in boardPiece as a List
    private List<?> filterByBoardPiece(Class<?> boardPiece) {
        return boardPieces.stream().filter(x -> x.getClass().equals(boardPiece))
                .map(boardPiece::cast)
                .collect(Collectors.toList());
    }

    public void addPlayer(Player player) {
        this.boardPieces.add(player);
    }

    public int getAmountOfPlayers() {
        return filterByBoardPiece(Player.class).size();
    }

    public Monster getMonster() {
        return (Monster) filterByBoardPiece(Monster.class).get(0);
    }

    public BoardPiece[][] getBoard() {
        return board;
    }

    private void setBoard(BoardPiece[][] board) {
        this.board = board;
    }

    public void setPieceAt(int x, int y, BoardPiece pieceToBePlaced) {
        this.board[x][y] = pieceToBePlaced;
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
