package io.github.monstersunited.monstergame.objects;



public class Position {
    public Position parent;
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
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public void setGCost(int gCost)
    {
        this.gCost = gCost;
    }
    public void setHCost(int hCost)
    {
        this.hCost = hCost;
    }
    public int getY()
    {
        return y;
    }
}