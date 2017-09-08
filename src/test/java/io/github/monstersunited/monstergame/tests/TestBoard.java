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
        test.addPlayer(player);

        assertNull(test.getPieceAt(1, 2));

        test.update();

        assertEquals(player, test.getPieceAt(1, 2));
    }
}
