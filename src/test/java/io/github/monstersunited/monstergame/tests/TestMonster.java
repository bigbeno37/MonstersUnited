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
        Wall wallOne = new Wall();
        Wall wallTwo = new Wall();
        board.addBoardPiece(wallOne);
        board.addBoardPiece(wallTwo);

        board.update();

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
        board.setMonster(monster);
        Player playerOne = new Player("One",7,7,1);
        board.addBoardPiece(playerOne);
        Player playerTwo = new Player("Two",6,7,2);
        board.addBoardPiece(playerTwo);

        board.update();

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
        board.setMonster(monster);
        Player playerOne = new Player("One",7,7,1);
        board.addBoardPiece(playerOne);
        monster.addPositions(board);

        monster.getNeighbours(monster.monsterPosition);
        //neighbour positions of monster is added to the neighbour list. The list should have size 8
        assertEquals(monster.neighbours.size(),8);
        //neighbour at neighbour.get(0) should be (4-1,4-1)=(3,3)
        assertEquals(monster.neighbours.get(0).getX(),3);
        assertEquals(monster.neighbours.get(0).getY(),3);
        //neighbour at neighbour.get(1) should be (4-1,4-0)=(3,4)
        assertEquals(monster.neighbours.get(1).getX(),3);
        assertEquals(monster.neighbours.get(1).getY(),4);
        //neighbour at neighbour.get(2) should be (4-1,4+1)=(3,5)
        assertEquals(monster.neighbours.get(2).getX(),3);
        assertEquals(monster.neighbours.get(2).getY(),5);
        //neighbour at neighbour.get(3) should be (4+0,4-1)=(4,3)
        assertEquals(monster.neighbours.get(3).getX(),4);
        assertEquals(monster.neighbours.get(3).getY(),3);
        //neighbour at neighbour.get(4) should be (4+0,4-1)=(4,5)
        assertEquals(monster.neighbours.get(4).getX(),4);
        assertEquals(monster.neighbours.get(4).getY(),5);
        //neighbour at neighbour.get(5) should be (4+1,4-1)=(5,3)
        assertEquals(monster.neighbours.get(5).getX(),5);
        assertEquals(monster.neighbours.get(5).getY(),3);
        //neighbour at neighbour.get(5) should be (4+1,4+0)=(5,4)
        assertEquals(monster.neighbours.get(6).getX(),5);
        assertEquals(monster.neighbours.get(6).getY(),4);
        //neighbour at neighbour.get(5) should be (4+1,4+1)=(5,5)
        assertEquals(monster.neighbours.get(7).getX(),5);
        assertEquals(monster.neighbours.get(7).getY(),5);




    }
    @Test
    public void TESTfindPath(){
        //Still needs work
        Board board = new Board();
        Monster monster = new Monster(4,4);
        board.setMonster(monster);
        Player playerOne = new Player("One",7,7,1);
        board.addBoardPiece(playerOne);

        board.update();

//        monster.moveTowardsClosestPlayer(board);
//        assertEquals(monster.path.size(),3);

    }

//    @Test public void TESTgetPath(){
//
//    }
//
//    @Test public void TESTmoveTowardsClosestPlayer(){
//
//    }
}
