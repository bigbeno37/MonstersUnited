package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static io.github.monstersunited.monstergame.objects.enums.EntityState.CHASING;

// The Monster that chases the nearest player around
public class Monster extends Entity implements Serializable {

    /*openSet stores the list of positions which are still to be evaluated for finding shortest path.
      closedSet stores the list of positions which are either walls or have been already evaluated
    */
    int[] pathSize = new int[4];
    private int playerCount=0;

    public Monster(int x, int y) {
        super.setPosition(x, y);
        super.setState(CHASING);
    }

    public void moveTowardsClosestPlayer(Board board) {
        List<PathFinder> pathfinder = new ArrayList<PathFinder>();
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board.getBoard()[i][j] instanceof Player)
                {
                    pathfinder.add(new PathFinder());
                    pathfinder.get(pathfinder.size()-1).addPositions(board);
                    pathSize[pathfinder.size()-1] = pathfinder.get(pathfinder.size()-1).findPath(board,(Player)board.getBoard()[i][j],this);

                }
            }
        }
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board.getBoard()[i][j] instanceof Player)
                {
                    playerCount++;
                    if(playerCount==getNearestPlayer(pathfinder))
                    {
                        this.setX(pathfinder.get(playerCount-1).getNewMonsterX());
                        this.setY(pathfinder.get(playerCount-1).getNewMonsterY());
                    }
                }

            }

        }
        playerCount=0;



    }

    private int getNearestPlayer(List<PathFinder> pathfinder) {
        int minValue = pathSize[0];
        int count=0;
        for (int i = 0; i < pathfinder.size(); i++)
        {
            if (pathSize[i] <= minValue)
            {
                minValue = pathSize[i];
                count = i+1;
            }
        }
        return count;
    }
}
