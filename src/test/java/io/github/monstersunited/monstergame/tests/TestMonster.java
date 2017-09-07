package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class TestMonster {
    @Test
    public void TESTaddPositions(){
        Board board = new Board();
        Monster monster = new Monster(4,4);
        board.setPieceAt(4,4,monster);
        Player playerOne = new Player("One",6,4,1);
        Player playerTwo = new Player("Two",5,4,2);
        board.setPieceAt(6,4,playerOne);
        board.setPieceAt(5,4,playerTwo);
        Wall wallOne = new Wall();
        Wall wallTwo = new Wall();
        board.setPieceAt(2,8,wallOne);
        board.setPieceAt(4,6,wallTwo);
        monster.addPositions(board);
        //Since there are only 5 objects in board, all other position objects should be in openSet.
        // So,there should be 77 objects in openSet
        assertEquals(monster.openSet.size(),1);
        //Since there are two walls in the board and it is added to closedSet, it should have two objects
        assertEquals(monster.closedSet.size(),2);
        //Since there is two players in the board, it should have two objects
        assertEquals(monster.players.size(),2);


    }

    @Test
    public void TESTgetDistance()
    {
        Board board = new Board();
        Monster monster = new Monster(1,2);
        board.setPieceAt(1,2,monster);
        Player playerOne = new Player("One",7,7,1);
        board.setPieceAt(7,7,playerOne);
        Player playerTwo = new Player("Two",6,7,2);
        board.setPieceAt(6,7,playerTwo);
        monster.addPositions(board);
        //(7,7) and (6,7) is just one straight position away. So, 10 is the distance.
        assertEquals(monster.getDistance(monster.players.get(1),monster.players.get(0)),10);
        //(6,7) to (1,2) is 5 diagonal positions and zero straight positions which should be 14*5=70
        assertEquals(monster.getDistance(monster.monsterPosition,monster.players.get(0)),70);
        //(7,7) to (1,2) is 5 diagonal positions and one straight position which should be 14*5+10=80
        assertEquals(monster.getDistance(monster.monsterPosition,monster.players.get(1)),80);

    }
    @Test
    public void TESTgetNeighbours()
    {
        Board board = new Board();
        Monster monster = new Monster(4,4);
        board.setPieceAt(4,4,monster);
        Player playerOne = new Player("One",7,7,1);
        board.setPieceAt(7,7,playerOne);
        monster.addPositions(board);

        monster.getNeighbours(monster.monsterPosition);
        //neighbour positions of monster is added to the neighbour list. The list should have size 8
        assertEquals(monster.neighbours.size(),8);

    }
    @Test
    public void TESTfindPath(){
        //Still needs work
        Board board = new Board();
        Monster monster = new Monster(4,4);
        board.setPieceAt(4,4,monster);
        Player playerOne = new Player("One",7,7,1);
        board.setPieceAt(7,7,playerOne);

//        monster.moveTowardsClosestPlayer(board);
//        assertEquals(monster.path.size(),3);

    }

    @Test public void TESTgetPath(){
        
    }

    @Test public void TESTmoveTowardsClosestPlayer(){

    }
}
