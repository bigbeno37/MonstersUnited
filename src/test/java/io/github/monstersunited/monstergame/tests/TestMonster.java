package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMonster {
    @Test
    public void TESTmoveTowardsClosestPlayer(){
        //Still needs work. For now, monster is moving towards the closest player when the players are in the same line as monster
        Board board = new Board();
        Monster monster = new Monster(0,1);
        board.setMonster(monster);
        Player playerOne = new Player("One",0,3,1);
        //Player playerTwo = new Player("Two",0,4,2);
        board.addBoardPiece(playerOne);
        //board.addBoardPiece(playerTwo);
        board.update();
        monster.moveTowardsClosestPlayer(board);
        assertEquals(0,monster.getX());
        assertEquals(2,monster.getY());
        //Monster should move to (7,4) towards the closer player
    }

}
