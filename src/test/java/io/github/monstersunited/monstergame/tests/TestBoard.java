package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.*;
import io.github.monstersunited.monstergame.server.MonsterServer;
import org.junit.Before;
import org.junit.Test;

import static io.github.monstersunited.monstergame.server.MonsterServer.board;
import static junit.framework.Assert.assertNotNull;
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
        test.update();
    }

    //incomplete make it print correctly- Simon
    @Test
    public void TestWallPlacement() {
        Board test = new Board();
        for (int i = 0 ; i<8; i++) {
            for (int j = 0 ; j<8; j++) {
                if ((i >= 1 && j >= 1) && (i <=7 && j <= 7)) {
                    if (i != 4 && j != 4) {
                        test.addBoardPiece(new Wall(i,j));
                    }

                }

            }
        }
        test.update();

        //TESTING
        for (int i = 0 ; i<8; i++) {
            for (int j = 0 ; j<8; j++) {

                    System.out.println(test.getPieceAt(i,j) + "\t cords"+i+ " " +j);

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
        test.addBoardPiece(box);

        assertNull(test.getPieceAt(1,1));
        test.update();
        assertEquals(box, test.getPieceAt(1, 1));
    }
    @Test
    public void TestSetMonster(){
        int j =0;
        Board board = new Board();
        Monster monster = new Monster(7,5);
        board.setMonster(monster);
        if(board.getPieceAt(7,5) instanceof Monster){
            j=2;
        }
        assertEquals(2,j);


    }
}

