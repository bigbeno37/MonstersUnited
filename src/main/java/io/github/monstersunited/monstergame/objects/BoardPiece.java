package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;

// Each piece that can be on the board must extend this class.
// Each BoardPiece will always have a position, thus its
// inclusion here
public abstract class BoardPiece implements Serializable {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
