package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.Board;
import io.github.monstersunited.monstergame.objects.BoardPiece;
import io.github.monstersunited.monstergame.objects.Monster;
import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.server.MonsterServer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class TestBoard {

    @BeforeClass
    public static void setUp() {
        MonsterServer.start(4);
    }

    @Before
    public void setUpBeforeTest() {
        MonsterServer.reset();
    }

    @Test
    public void updateBoardCorrectlyUpdatesBoard() {
        Board board = new Board();

        List<Player> players = new ArrayList<>();
        players.add(new Player("nick", 2, 4, 1));
        players.add(new Player("ncik2", 3, 6, 2));

        Monster monster = new Monster(3, 4);

        board.update();

        // TODO
        // Make this an actual check instead of always being correct
        return;
    }
    @Before
    public void TestResetBoard() {
        Board test = new Board();
        test.resetBoard();

        for (int i = 0; i < test.getBoard().length; i++) {
            for (int j = 0; j < test.getBoard().length; j++) {
                assertNull(test.getPieceAt(i, j));
            }
        }
    }

    @Test
    public void TestUpdate(){
        Board test = new Board();
        test.update();
        for (BoardPiece piece : MonsterServer.board.getBoardPieces()) {
            test.setPieceAt(piece.getX(),piece.getY(),piece);
        }
    }
}
