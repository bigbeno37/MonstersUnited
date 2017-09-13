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
        super.setPosition(x, y);
        super.setState(CHASING);
    }

    public void moveTowardsClosestPlayer(Board board) {

        // TODO
        // Call methods in PathFinder to determine which
        // direction to go

        //initilizae the min distance from player to Monster
        int minDistance = 100;

        //a list for every pieces on boards
        ArrayList<BoardPiece> piecesList = new ArrayList<>();

        //run through board to add all entity to piecesList
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getPieceAt(i, j) instanceof Entity) {
                    piecesList.add(board.getPieceAt(i, j));
                }
            }
        }

        //calculate distance for Monster to each player
        for (BoardPiece pieces: piecesList) {
            int tempDistance = 0;
            if (!(pieces instanceof Player)) {
                continue;
            } else {
                //calculate distance from each player to Monster
                tempDistance = Math.abs(pieces.getX() - super.getX()) + Math.abs(pieces.getY() - super.getY());
                if (tempDistance < minDistance) {
                    minDistance = tempDistance;
                }
            }
        }

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
