package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;

// An Entity is a BoardPiece that can move and has its own behaviours,
// thus the inclusion of velocity as seen
public abstract class Entity extends BoardPiece implements Serializable{
    private int velX;
    private int velY;

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    public void setVelocity(int velX, int velY) {
        this.velX = velX;
        this.velY = velY;
    }
}
