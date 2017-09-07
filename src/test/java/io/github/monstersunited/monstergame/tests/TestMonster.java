package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.Board;
import io.github.monstersunited.monstergame.objects.Monster;
import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.objects.Wall;
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
        //Since there is only one monster in the board and it is added to openSet, it should have one object
        assertEquals(monster.openSet.size(),1);
        //Since there are two walls in the board and it is added to closedSet, it should have two objects
        assertEquals(monster.closedSet.size(),2);
        //Since there is only one player in the board, it should have one object
        assertEquals(monster.players.size(),2);
    }
}
