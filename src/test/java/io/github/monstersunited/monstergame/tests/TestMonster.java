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


        playerOne.setX(1);
        playerOne.setY(0);
        //PlayerOne moves left
        playerTwo.setX(0);
        playerTwo.setY(4);
        //playerTwo moves right
        playerThree.setX(7);
        playerThree.setY(6);
        //three moves left
        playerFour.setX(5);
        playerFour.setY(8);
        //four moves left
        board.update();

        monster.moveTowardsClosestPlayer(board);
        assertEquals(3,monster.getX());
        assertEquals(0,monster.getY());

        //Monster is at (4,0) and should move to to (3,0) towards playerOne at (1,0)

        playerOne.setX(1);
        playerOne.setY(8);
        //PlayerOne moves up
        playerTwo.setX(0);
        playerTwo.setY(3);
        //playerTwo moves up

        //other players dont move
        board.update();

        monster.moveTowardsClosestPlayer(board);
        assertEquals(2,monster.getX());
        assertEquals(0,monster.getY());

        //Monster is at (3,0) and should move to to (2,0) towards playerOne at (0,3)


        monster.setX(0);
        monster.setY(4);

        playerOne.setX(0);
        playerOne.setY(1);

        playerTwo.setX(0);
        playerTwo.setY(7);

        playerThree.setX(3);
        playerThree.setY(4);

        board.update();

        monster.moveTowardsClosestPlayer(board);

        //Three players are set to equal distance from the monster. Because of the monster class used for loop with i,j
        //for all boardpieces, the monster should move towards the player with the highest i(x position). If there are two players with
        // highest i at an equal distance from monster then the player with highest j(y position) will be chased. In this case playerThree
        //has the highest x position. So, monster should move to (1,4)
        assertEquals(1,monster.getX());
        assertEquals(4,monster.getY());

    }

}
