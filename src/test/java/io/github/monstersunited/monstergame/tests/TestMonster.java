package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.*;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestMonster {
    @Test
    public void TESTmoveTowardsClosestPlayer(){
        Board board = new Board();
        Monster monster = new Monster(4,4);
        board.setMonster(monster);
        Player playerOne = new Player("One",2,4,1);
        Player playerTwo = new Player("Two",8,4,2);
        board.addBoardPiece(playerOne);
        board.addBoardPiece(playerTwo);
        board.update();
        monster.moveTowardsClosestPlayer(board);
        assertEquals(3,monster.getX());
        assertEquals(4,monster.getX());
        //Monster should move to (3,4) towards the closer player
    }
    
}
