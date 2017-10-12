package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;

public class Box extends BoardPiece implements Serializable {
    private int timer;
    private int x;
    private int y;
    public Box(int time,int x, int y) {
        this.timer = time;
        this.x = x;
        this.y =y;
        super.setPosition(x,y);
    }

    public int getTimeLeft() {
        return timer;
    }

    public int reduceTimer() {
        return --timer;
    }
}
