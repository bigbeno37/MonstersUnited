package io.github.monstersunited.monstergame.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathFinder {
    public List<Position> openSet = new ArrayList<Position>();
    public List<Position> closedSet = new ArrayList<Position>();
    public List<Position> players = new ArrayList<>();
    public List<Position> path = new ArrayList<Position>();
    public List<Position> neighbours = new ArrayList<Position>();
    public Position monsterPosition = new Position(4,4);

    /*addPositions creates all the Positions objects necessary for the a star algorithm to work.
     It creates a monster,players,closedSet,openSet objects for the a star algorithm*/

    public void addPositions(Board board) {
        int i, j;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (board.getBoard()[i][j] instanceof Monster) {
                    monsterPosition.setX(i);
                    monsterPosition.setY(j);
                    openSet.add(monsterPosition);
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
               /* else
                {
                    openSet.add(new Position(i,j));
                }*/
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
            //Problem in this for loop
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
