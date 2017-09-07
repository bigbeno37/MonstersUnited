package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;
import java.util.*;

// The Monster that chases the nearest player around
public class Monster extends Entity implements Serializable{
    public void monsterGoesToNearestPlayer() {

    }

    public Monster(int x, int y) {
        super.setPosition(x, y);
    }

    public void moveTowardsClosestPlayer(Board board) {
        int i,j,monsterX,monsterY,playerCount=0;
        int playerPositionX[] = new int [4];
        int playerPositionY[] = new int[4];
        List<Position> openSet = new ArrayList<Position>();
        List<Position> closedSet = new ArrayList<Position>();
        /*playerPositionX[] and playerPositionY[] stores the position of the players and playerCount counts the number of players
          openSet stores the list of nodes which are still to be evaluated for finding shortest path.
          closedSet stores the list of nodes which are either walls or are nodes which are marked as closed when a better
          path is found.
        */
        for(i=0;i<9;i++)
        {
            for(j=0;j<9;j++)
            {
                if(board.getBoard()[i][j] instanceof Monster)
                {
                    Position monster = new Position(i,j);
                    openSet.add(new Position(i,j));
                    //Finds the current position of the monster
                }
                else if(board.getBoard()[i][j] instanceof Player)
                {
                    playerPositionX[playerCount] = i;
                    playerPositionY[playerCount] = j;
                    playerCount++;
                    //Saves the position of players according to the number of players in the game and playerCount is incremented
                }
                else if(board.getBoard()[i][j] instanceof Wall)
                {

                }
            }
        }


        for(i=0;i<playerCount;i++)
        {

        }
        // TODO
        // Move towards the closest player
        // Given is a list of Players which you need to loop through
        // and determine whoever is closest based on the board that
        // is passed in. Check for obstacles and walls too
    }
}
