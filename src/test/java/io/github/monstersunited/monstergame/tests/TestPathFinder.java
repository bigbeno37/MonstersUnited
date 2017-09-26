package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.Board;
import io.github.monstersunited.monstergame.objects.Monster;
import io.github.monstersunited.monstergame.objects.PathFinder;
import io.github.monstersunited.monstergame.objects.Player;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestPathFinder {

    @Test
    public void TESTgetDistance() {
        Board board = new Board();
        Monster monster = new Monster(1, 2);
        PathFinder path = new PathFinder();
        board.getMonster().setPosition(1, 2);
        Player playerOne = new Player("One", 7, 7, 1);
        board.addBoardPiece(playerOne);
        Player playerTwo = new Player("Two", 6, 7, 2);
        board.addBoardPiece(playerTwo);

        board.update();

        path.addPositions(board);
        //(7,7) and (6,7) is just one straight position away. So, 10 is the distance.
        assertEquals(path.getDistance(path.players.get(1), path.players.get(0)), 10);
        //(6,7) to (1,2) is 5 diagonal positions and zero straight positions which should be 14*5=70
        assertEquals(path.getDistance(path.monsterPosition, path.players.get(1)), 70);
        //(7,7) to (1,2) is 5 diagonal positions and one straight position which should be 14*5+10=80
        assertEquals(path.getDistance(path.monsterPosition, path.players.get(0)), 80);

    }

    @Test
    public void TESTgetNeighbours() {
        Board board = new Board();
        Monster monster = new Monster(4, 4);
        PathFinder path = new PathFinder();
        board.getMonster().setPosition(4, 4);
        Player playerOne = new Player("One", 7, 7, 1);
        board.addBoardPiece(playerOne);
        board.update();
        path.addPositions(board);

        path.getNeighbours(path.monsterPosition);
        //neighbour positions of monster is added to the neighbour list. The list should have size 8
        assertEquals(path.neighbours.size(), 8);
        //neighbour at neighbour.get(0) should be (4-1,4-1)=(3,3)
        //assertEquals(path.neighbours.get(0).getX(),3);
        assertEquals(path.neighbours.get(0).getY(), 3);
        //neighbour at neighbour.get(1) should be (4-1,4-0)=(3,4)
        assertEquals(path.neighbours.get(1).getX(), 3);
        assertEquals(path.neighbours.get(1).getY(), 4);
        //neighbour at neighbour.get(2) should be (4-1,4+1)=(3,5)
        assertEquals(path.neighbours.get(2).getX(), 3);
        assertEquals(path.neighbours.get(2).getY(), 5);
        //neighbour at neighbour.get(3) should be (4+0,4-1)=(4,3)
        assertEquals(path.neighbours.get(3).getX(), 4);
        assertEquals(path.neighbours.get(3).getY(), 3);
        //neighbour at neighbour.get(4) should be (4+0,4-1)=(4,5)
        assertEquals(path.neighbours.get(4).getX(), 4);
        assertEquals(path.neighbours.get(4).getY(), 5);
        //neighbour at neighbour.get(5) should be (4+1,4-1)=(5,3)
        assertEquals(path.neighbours.get(5).getX(), 5);
        assertEquals(path.neighbours.get(5).getY(), 3);
        //neighbour at neighbour.get(5) should be (4+1,4+0)=(5,4)
        assertEquals(path.neighbours.get(6).getX(), 5);
        assertEquals(path.neighbours.get(6).getY(), 4);
        //neighbour at neighbour.get(5) should be (4+1,4+1)=(5,5)
        assertEquals(path.neighbours.get(7).getX(), 5);
        assertEquals(path.neighbours.get(7).getY(), 5);


    }

    @Test
    public void TESTfindPath() {
        //Still needs work
        Board board = new Board();
        Monster monster = new Monster(3, 2);
        PathFinder path = new PathFinder();
        board.getMonster().setPosition(3, 2);
        Player playerOne = new Player("One", 7, 7, 1);
        board.addBoardPiece(playerOne);
        board.update();

//        monster.moveTowardsClosestPlayer(board);
//        assertEquals(monster.path.size(),3);

    }
}
