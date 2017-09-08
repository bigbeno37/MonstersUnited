package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.Board;
import io.github.monstersunited.monstergame.objects.Box;
import io.github.monstersunited.monstergame.objects.Player;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class TestBoard {

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

        Player player = new Player("Nick", 1, 2, 1);
        test.addBoardPiece(player);

        assertNull(test.getPieceAt(1, 2));

        test.update();

        assertEquals(player, test.getPieceAt(1, 2));
    }

    @Test
    public void doPlayerBlocksShowOnBoard() {
        Board test = new Board();

        assertNull(test.getPieceAt(1,1));

        Player player = new Player("Nick", 0, 0, 1);
        Box box = new Box(10);
        box.setPosition(1,1);
        player.setBox(box);

        test.addBoardPiece(player);

        assertNull(test.getPieceAt(1,1));
        test.update();
        assertEquals(box, test.getPieceAt(1, 1));
    }
}
