package io.github.monstersunited.monstergame.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathFinder
{
    public static List<Position> openSet = new ArrayList<Position>();
    public static List<Position> closedSet = new ArrayList<Position>();
    public static List<Position> players = new ArrayList<>();
    public static List<Position> path = new ArrayList<Position>();
    public static List<Position> neighbours = new ArrayList<Position>();
    public static Position monsterPosition;
    public int newMonsterX=0,newMonsterY=0;
    public void setNewMonsterX(int x)   {this.newMonsterX = x;}
    public void setNewMonsterY(int y)   {this.newMonsterY = y;}
    public int getNewMonsterX()
    {
        return newMonsterX;
    }
    public int getNewMonsterY()
    {
        return newMonsterY;
    }
    /*addPositions creates all the Positions objects necessary for the a star algorithm to work.
     It creates a monster,players,closedSet,openSet objects for the a star algorithm*/

    public void addPositions(Board board)
    {
        int i, j;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                if (board.getBoard()[i][j] instanceof Monster)
                {
                    monsterPosition = new Position(i,j);
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

            }
        }
    }


    public int findPath(Board board, Player play, Monster monster)
    {
        Position player = new Position(0,0);
        for(int i=0; i<players.size();i++)
        {
            if(play.getX()==players.get(i).getX() && play.getY()==players.get(i).getY())
            {
                player.setX(play.getX());
                player.setY(play.getY());
            }

        }
        Position start = new Position(monster.getX(),monster.getY());

        openSet.add(start);

        //There should be one position in openset at this point which is the monsterposition
        while (openSet.size()>0)
        {
            Position currentPosition = openSet.get(0);
            //First time currentposition is set to openset first element


            for(int i = 0;i<openSet.size();i++)
            {
                openSet.get(i).setGCost(getDistance(openSet.get(i),monsterPosition));
                openSet.get(i).setHCost(getDistance(openSet.get(i),player));
                //Sets the gCost and fCost of all positions in the openSet
            }
            for (int i = 1; i < openSet.size(); i++) {
                if (openSet.get(i).fCost() < currentPosition.fCost() || (openSet.get(i).fCost() == currentPosition.fCost()
                        && openSet.get(i).getHCost() < currentPosition.getHCost())) {
                    currentPosition = openSet.get(i);
                }
            }

            path.add(currentPosition);
            openSet.remove(currentPosition);
            closedSet.add(currentPosition);

            if ((currentPosition.getX() == player.getX()) && currentPosition.getY() == player.getY())
            {
                setNewMonsterX(path.get(1).getX());
                setNewMonsterY(path.get(1).getY());
                return path.size();
            }


            for(Position neighbour: getNeighbours(currentPosition))
            {
                if (closedSet.contains(neighbour) || (board.getBoard()[neighbour.getX()][neighbour.getY()] instanceof Wall))
                {
                    continue;
                }
                int newMovementCostToNeighbour = currentPosition.getGCost() + getDistance(currentPosition,neighbour);
                if(newMovementCostToNeighbour < neighbour.getGCost() || !openSet.contains(neighbour))
                {
                    neighbour.setGCost(newMovementCostToNeighbour);
                    neighbour.setHCost(getDistance(neighbour,player));
                    neighbour.parent = currentPosition;

                    if(!openSet.contains(neighbour))
                    {
                        openSet.add(neighbour);
                    }
                }
            }


        }
        return 0;
    }

    public static List<Position> getNeighbours(Position position)
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

    public static int getDistance(Position a, Position b)
    {
        int dstX = Math.abs(a.getX()-b.getX());
        int dstY = Math.abs(a.getY()-b.getY());

        if(dstX>dstY)
            return 14*dstY + 10*(dstX-dstY);

        return 14*dstX + 10*(dstY-dstX);

    }


    public static void getPath(Position monster,Position player)
    {
        Position currentPosition = player;
        while(currentPosition != monster)
        {
            path.add(currentPosition);
            currentPosition = currentPosition.parent;
        }
        Collections.reverse(path);
    }
}
