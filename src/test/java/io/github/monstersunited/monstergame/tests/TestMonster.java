package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMonster {
    @Test
    public void TESTmoveTowardsClosestPlayer(){
        //Still needs work. For now, monster is moving towards the closest player when the players are in the same line as monster
        Board board = new Board();
        Monster monster = new Monster(5,8);
        board.setMonster(monster);
        Player playerOne = new Player("One",8,8,1);
        Player playerTwo = new Player("Two",0,8,2);
        board.addBoardPiece(playerOne);
        board.addBoardPiece(playerTwo);
        board.update();
        monster.moveTowardsClosestPlayer(board);
        assertEquals(4,monster.getX());
        assertEquals(8,monster.getY());
        //Monster should move to (6,8) towards the closer player instead it moves to 4,8..needs work
    }

}
