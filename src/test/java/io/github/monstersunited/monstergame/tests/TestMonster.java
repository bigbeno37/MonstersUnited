package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMonster {
    @Test
    public void TESTmoveTowardsClosestPlayer(){
        //Still needs work. For now, monster is moving towards the closest player when the players are in the same line as monster
        Board board = new Board();
        Monster monster = new Monster(4,1);
        board.setMonster(monster);
        Player playerOne = new Player("One",1,0,1);
        Player playerTwo = new Player("Two",0,4,2);
        Player playerThree = new Player("Three",8,7,3);
        Player playerFour = new Player("Three",6,0,4);
        board.addBoardPiece(playerOne);
        board.addBoardPiece(playerTwo);
        board.addBoardPiece(playerThree);
        board.addBoardPiece(playerFour);
        board.update();
        monster.moveTowardsClosestPlayer(board);
        assertEquals(5,monster.getX());
        assertEquals(0,monster.getY());
        //Monster is at (4,1) and Monster should move to (5,0) towards the closer player four at(6,0)



        playerOne.setX(2);
        playerOne.setY(0);
        //PlayerOne moves right
        playerTwo.setX(8);
        playerTwo.setY(4);
        //playerTwo moves left
        playerThree.setX(8);
        playerThree.setY(6);
        //three moves up
        playerFour.setX(6);
        playerFour.setY(8);


        //four moves up
        board.update();

        monster.moveTowardsClosestPlayer(board);
        assertEquals(4,monster.getX());
        assertEquals(0,monster.getY());

        //Monster is at (5,0) and Monster should move to (4,0) towards the closer player one at (2,0)


        playerOne.setX(2);
        playerOne.setY(8);
        //PlayerOne moves up
        playerTwo.setX(0);
        playerTwo.setY(4);
        //playerTwo moves right
        playerThree.setX(7);
        playerThree.setY(6);
        //three moves left
        playerFour.setX(6);
        playerFour.setY(0);
        //four moves down
        board.update();

        monster.moveTowardsClosestPlayer(board);
        assertEquals(5,monster.getX());
        assertEquals(0,monster.getY());

        //Monster is at (4,0) and should move to (5,0)towards the closer player one at (6,0)

    }

}
