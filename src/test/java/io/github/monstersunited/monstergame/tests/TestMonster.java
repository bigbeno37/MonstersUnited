package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMonster {
    @Test
    public void TESTaddPositions(){
        Board board = new Board();
        Monster monster = new Monster(4,4);
        board.setMonster(monster);
        Player playerOne = new Player("One",6,4,1);
        Player playerTwo = new Player("Two",5,4,2);
        board.addBoardPiece(playerOne);
        board.addBoardPiece(playerTwo);
        Wall wallOne = new Wall(1,1);
        Wall wallTwo = new Wall(2,2);
        board.addBoardPiece(wallOne);
        board.addBoardPiece(wallTwo);

        board.update();

//        monster.addPositions(board);
//        //Since there are only 5 objects in board, all other position objects should be in openSet.
//        // So,there should be 77 objects in openSet
//        assertEquals(monster.openSet.size(),1);
//        //Since there are two walls in the board and it is added to closedSet, it should have two objects
//        assertEquals(monster.closedSet.size(),2);
//        //Since there is two players in the board, it should have two objects
//        assertEquals(monster.players.size(),2);


    }



//    @Test public void TESTgetPath(){
//
//    }
//
//    @Test public void TESTmoveTowardsClosestPlayer(){
//
//    }
}
