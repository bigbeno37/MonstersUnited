package io.github.monstersunited.monstergame.objects;

import io.github.monstersunited.monstergame.objects.enums.EntityState;

import java.io.Serializable;
import java.util.*;


import static io.github.monstersunited.monstergame.objects.enums.EntityState.CHASING;

// The Monster that chases the nearest player around
public class Monster extends Entity implements Serializable {
    public List<Position> openSet = new ArrayList<Position>();
    public List<Position> closedSet = new ArrayList<Position>();
    public List<Position> players = new ArrayList<>();
    public List<Position> path = new ArrayList<Position>();
    public List<Position> neighbours = new ArrayList<Position>();
    public Position monsterPosition = new Position(4,4);
    /*openSet stores the list of positions which are still to be evaluated for finding shortest path.
      closedSet stores the list of positions which are either walls or have been already evaluated
    */

    public Monster(int x, int y) {
        super.setPosition(x, y);
        super.setState(CHASING);
    }

    public void moveTowardsClosestPlayer(Board board) {
        List<Integer> distance = new ArrayList<Integer>();
        int i = 0;
        int playerX, playerY, minDistance;
        /*playerX and playerY are the co-ordinates of the player who is closest to monster and minDistance
          is the distance between that player and monster.
          */
        addPositions(board);
        for (Position tempPlayers : players)
        {
            distance.add(findPath(board, tempPlayers, this));
            i++;
        }
        playerX = players.get(0).getX();
        playerY = players.get(0).getY();
        minDistance = distance.get(0);
        /*The first player found is set to have the minimum distance and then the player with minimum distance
        and the minimum distance from distance list is found using a for loop and an if loop
        */
        for (int j = 1; j < distance.size(); j++) {
            if (distance.get(j) < minDistance) {
                playerX = players.get(j).getX();
                playerY = players.get(j).getY();
                minDistance = distance.get(j);
            }
        }

    }
    // TODO
    // Move towards the closest player
    // Given is a list of Players which you need to loop through
    // and determine whoever is closest based on the board that
    // is passed in. Check for obstacles and walls too



    /*addPositions creates all the Positions objects necessary for the a star algorithm to work.
     It creates a monster,players,closedSet,openSet objects for the a star algorithm*/

    public void addPositions(Board board) {
        int i, j;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (board.getBoard()[i][j] instanceof Monster) {
                    openSet.add(new Position(i, j));
                    monsterPosition.setX(i);
                    monsterPosition.setY(j);
                    //Saves the current position of the monster
                } else if (board.getBoard()[i][j] instanceof Player)

                {
                    players.add(new Position(i, j));
                    //Saves the position of players
                } else if (board.getBoard()[i][j] instanceof Wall)
                {
                    closedSet.add(new Position(i, j));
                    //walls are added to closed set
                }
                else
                {
                    openSet.add(new Position(i,j));
                }
            }
        }
    }

    public int findPath(Board board, Position player, Monster monster)
    {
        Position target = new Position(monster.getX(),monster.getY());
        for(int i = 0;i<openSet.size();i++)
        {
            openSet.get(i).setGCost(getDistance(openSet.get(i),monsterPosition));
            openSet.get(i).setHCost(getDistance(openSet.get(i),player));
            //Sets the gCost and fCost of all positions in the openSet
        }
        while (openSet.size()>0)
        {
            Position currentPosition = openSet.get(0);
            for (int i = 1; i < openSet.size(); i++) {
                if (openSet.get(i).fCost() < currentPosition.fCost() || openSet.get(i).fCost() == currentPosition.fCost()
                        && openSet.get(i).getHCost() < currentPosition.getHCost()) {
                    currentPosition = openSet.get(i);
                }
            }

            openSet.remove(currentPosition);
            closedSet.add(currentPosition);

            if (currentPosition == player) {
                getPath(player,target);
                return path.size();
            }

            for(Position neighbour: getNeighbours(currentPosition))
            {
                if(closedSet.contains(neighbour))
                    continue;

                int newMovementCostToNeighbour = currentPosition.getGCost() + getDistance(currentPosition,neighbour);
                if(newMovementCostToNeighbour < neighbour.getGCost() || !openSet.contains(neighbour))
                {
                    neighbour.setGCost(newMovementCostToNeighbour);
                    neighbour.setHCost(getDistance(neighbour,player));
                    neighbour.parent = currentPosition;

                    if(!openSet.contains(neighbour))
                        openSet.add(neighbour);
                }
            }


        }
        return 0;
    }

    public List<Position> getNeighbours(Position position)
    {
        neighbours.clear();
        //neighbours list is cleared to remove previous neighbours

        for (int x = -1; x <= 1; x++)
        {
            for (int y = -1; y <= 1; y++)
            {
                if (x == 0 && y == 0)
                    continue;

                int checkX = position.getX() + x;
                int checkY = position.getY() + y;

                if (checkX >= 0 && checkX < 9 && checkY < 9)
                //9 is board height and breadth
                {
                    neighbours.add(new Position(checkX, checkY));
                }
            }

        }
        return neighbours;
    }

    public int getDistance(Position a, Position b)
    {
        int dstX = Math.abs(a.getX()-b.getX());
        int dstY = Math.abs(a.getY()-b.getY());

        if(dstX>dstY)
            return 14*dstY + 10*(dstX-dstY);

        return 14*dstX + 10*(dstY-dstX);

    }


    void getPath(Position monster,Position player)
    {
     Position currentPosition = player;
     while(currentPosition != monster) {
         path.add(currentPosition);
         currentPosition = currentPosition.parent;
     }
     Collections.reverse(path);
    }
}
