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
        int shortestDistance = 100;
        int nearPlayerX=0,nearPlayerY=0;
        PathFinder path = new PathFinder();
        path.addPositions(board);
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board.getBoard()[i][j] instanceof Player && shortestDistance>path.findPath(board,(Player)board.getBoard()[i][j],this))
                {
                    shortestDistance=path.findPath(board,(Player)board.getBoard()[i][j],this);
                    nearPlayerX=i;
                    nearPlayerY=j;
                }
            }
        }
        path.findPath(board,(Player)board.getBoard()[nearPlayerX][nearPlayerY],this);
        this.setX(path.getNewMonsterX());
        this.setY(path.getNewMonsterY());


    }
}
