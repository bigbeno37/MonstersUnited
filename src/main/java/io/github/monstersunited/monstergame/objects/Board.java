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
        //this double forloop should place the walls in the corrrect positions
        for (int i = 0 ; i<8; i++) {
            for (int j = 0 ; j<8; j++) {
                if ((i >= 1 && j >= 1) || (i <=7 && j <= 7)) {
                    if (i == 4 || j == 4) {
                        continue;
                    }
                    setPieceAt(i,j,new Wall());
                }

            }
            update();

        }
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

    public void addBoardPiece(BoardPiece piece) {
        if (!(piece instanceof Monster)) {
            this.boardPieces.add(piece);
        }
    }

    public int getAmountOfPlayers() {
        return filterByBoardPiece(Player.class).size();
    }

    public Monster getMonster() {
        return (Monster) filterByBoardPiece(Monster.class).get(0);
    }

    public void setMonster(Monster monster) {
        for(BoardPiece piece: boardPieces) {
            if (piece instanceof Monster) {
                piece = monster;
            }
        }
    }

    public BoardPiece[][] getBoard() {
        return board;
    }

    private void setBoard(BoardPiece[][] board) {
        this.board = board;
    }

    private void setPieceAt(int x, int y, BoardPiece pieceToBePlaced) {
        this.board[x][y] = pieceToBePlaced;
    }
    
    public BoardPiece getPieceAt(int x, int y) {
        return this.board[x][y];
    }

    public void resetBoard() {
        for (int i=0; i<9 ; i++){
            for (int j=0; j<9;j++){
                board[i][j] = null;
            }
        }
    }

    public void update() {
        // TODO
        // Parse through the boardPieces list and update their positions on this board
        resetBoard();
        for (BoardPiece piece : boardPieces) {
            setPieceAt(piece.getX(), piece.getY(), piece);
        }
    }

    public List<BoardPiece> getBoardPieces() {
        return boardPieces;
    }
}
