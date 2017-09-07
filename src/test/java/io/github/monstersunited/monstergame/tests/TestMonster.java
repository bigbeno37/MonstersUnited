package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMonster {
    @Test
    public void TESTaddPositions(){
        Board board = new Board();
        Monster monster = new Monster(4,4);
        board.setPieceAt(4,4,monster);
        Player playerOne = new Player("One",7,7,1);
        Player playerTwo = new Player("Two",3,4,2);
        board.setPieceAt(7,7,playerOne);
        board.setPieceAt(3,4,playerTwo);
        Wall wallOne = new Wall();
        Wall wallTwo = new Wall();
        board.setPieceAt(2,8,wallOne);
        board.setPieceAt(4,6,wallTwo);
        monster.addPositions(board);
        //Since there are only 5 objects in board, all other position objects should be in openSet.
        // So,there should be 77 objects in openSet
        assertEquals(monster.openSet.size(),77);
        //Since there are two walls in the board and it is added to closedSet, it should have two objects
        assertEquals(monster.closedSet.size(),2);
        //Since there is two players in the board, it should have two objects
        assertEquals(monster.players.size(),2);



    }

    @Test
    public void TESTfindPath(){
        Board board = new Board();
        Monster monster = new Monster(4,4);
        board.setPieceAt(4,4,monster);
        Player playerOne = new Player("One",7,7,1);
        board.setPieceAt(7,7,playerOne);

        monster.moveTowardsClosestPlayer(board);
        assertEquals(monster.path.size(),3);

    }
}
