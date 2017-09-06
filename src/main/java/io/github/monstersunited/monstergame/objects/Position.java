package io.github.monstersunited.monstergame.objects;



public class Position {
    private int x,y;
    public Position(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    private int hCost,gCost;
    public int fCost()
    {
        return hCost+gCost;
    }
    public int getGCost()
    {
        return gCost;
    }

    public int getHCost()
    {
        return hCost;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}