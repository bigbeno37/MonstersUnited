package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;
import java.util.ArrayList;

import static io.github.monstersunited.monstergame.objects.enums.EntityState.CHASING;

// The Monster that chases the nearest player around
public class Monster extends Entity implements Serializable {

    /*openSet stores the list of positions which are still to be evaluated for finding shortest path.
      closedSet stores the list of positions which are either walls or have been already evaluated
    */

    public Monster(int x, int y) {
        super.setPosition(y, x);
        super.setState(CHASING);
    }

    public void moveTowardsClosestPlayer(Board board) {

        // TODO
        // Call methods in PathFinder to determine which
        // direction to go
        PathFinder path = new PathFinder();


//        List<Integer> distance = new ArrayList<Integer>();
//        int i = 0;
//        int playerX, playerY, minDistance;
//        /*playerX and playerY are the co-ordinates of the player who is closest to monster and minDistance
//          is the distance between that player and monster.
//          */
//        addPositions(board);
//        for (Position tempPlayers : players)
//        {
//            distance.add(findPath(board, tempPlayers, this));
//            i++;
//        }
//        playerX = players.get(0).getX();
//        playerY = players.get(0).getY();
//        minDistance = distance.get(0);
//        /*The first player found is set to have the minimum distance and then the player with minimum distance
//        and the minimum distance from distance list is found using a for loop and an if loop
//        */
//        for (int j = 1; j < distance.size(); j++) {
//            if (distance.get(j) < minDistance) {
//                playerX = players.get(j).getX();
//                playerY = players.get(j).getY();
//                minDistance = distance.get(j);
//            }
//        }

    }
}
