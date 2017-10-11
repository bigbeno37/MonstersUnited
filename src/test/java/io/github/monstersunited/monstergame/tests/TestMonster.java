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
        Player three = new Player("Three",8,7,3);
        Player four = new Player("Three",6,0,4);
        board.addBoardPiece(playerOne);
        board.addBoardPiece(playerTwo);
        board.addBoardPiece(three);
        board.addBoardPiece(four);
        board.update();
        monster.moveTowardsClosestPlayer(board);
        assertEquals(5,monster.getX());
        assertEquals(0,monster.getY());
        //Monster should move to (5,0) towards the closer player
    }

}
