package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;

public class Box extends BoardPiece implements Serializable {
    private int timer;
    public Box(int time) {
        this.timer = time;

    }

    public int getTimeLeft() {
        return timer;
    }

    public int reduceTimer() {
        return --timer;
    }
}
