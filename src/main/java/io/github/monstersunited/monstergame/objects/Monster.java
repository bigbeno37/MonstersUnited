package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;
import java.util.*;

// The Monster that chases the nearest player around
public class Monster extends Entity implements Serializable{
    public List<Position> openSet = new ArrayList<Position>();
    public List<Position> closedSet = new ArrayList<Position>();
    public List<Position> players = new ArrayList<>();
    /*openSet stores the list of nodes which are still to be evaluated for finding shortest path.
      closedSet stores the list of nodes which are either walls or are nodes which are marked as closed when a better
      path is found.
    */
    public Monster(int x, int y) {
        super.setPosition(x, y);
    }
    public void moveTowardsClosestPlayer(Board board) {
        addPositions(board);
    }


    /*addPositions creates all the Positions objects necessary for the a star algorithm to work.
     It creates a monster,players,closedSet,openSet objects for the a star algorithm*/

    public void addPositions(Board board) {
        int i,j;


        for(i=0;i<9;i++)
        {
            for(j=0;j<9;j++)
            {
                if(board.getBoard()[i][j] instanceof Monster)
                {
                    Position monster = new Position(i,j);
                    openSet.add(new Position(i,j));
                    //Saves the current position of the monster
                }
                else if(board.getBoard()[i][j] instanceof Player)

                {
                    players.add(new Position(i,j));
                    //Saves the position of players
                }
                else if(board.getBoard()[i][j] instanceof Wall) {
                    closedSet.add(new Position(i, j));
                    //walls are added to closed set
                }
            }
        }


        // TODO
        // Move towards the closest player
        // Given is a list of Players which you need to loop through
        // and determine whoever is closest based on the board that
        // is passed in. Check for obstacles and walls too
    }
}
