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
    public static List<PathFinder> paths = new ArrayList<PathFinder>();
    public Monster(int x, int y) {
        super.setPosition(x, y);
        super.setState(CHASING);
    }

    public void moveTowardsClosestPlayer(Board board) {

        // TODO
        int nearPlayerX=0,nearPlayerY=0;

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board.getBoard()[i][j] instanceof Player)
                {
                    paths.add(new PathFinder());
                    paths.get(paths.size()-1).addPositions(board);
                    pathSize[paths.size()-1] = paths.get(paths.size()-1).findPath(board,(Player)board.getBoard()[i][j],this);

                }
            }
        }
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board.getBoard()[i][j] instanceof Player)
                {
                    for(int z = 0; z < paths.size();z++)
                    {
                        if(z==getNearestPlayer())
                        {
                            this.setX(paths.get(z).getNewMonsterX());
                            this.setY(paths.get(z).getNewMonsterY());
                        }

                    }
                }
            }

            }




    }
    private int getNearestPlayer()
    {
        int count=0;

        for(int i=0;i<paths.size()-1;i++)
        {
            if(pathSize[i+1] < pathSize[i])
            {
                count = i+1;
            }
        }
        return count;
    }
}
