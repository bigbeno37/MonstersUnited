package io.github.monstersunited.monstergame.objects;

import io.github.monstersunited.monstergame.client.gui.features.Assets;
import io.github.monstersunited.monstergame.client.gui.features.TileGrid;
import io.github.monstersunited.monstergame.client.gui.features.boxTile;

import java.awt.*;
import java.io.Serializable;

public class Box extends BoardPiece implements Serializable {
    private int timer;

    public Box(int time) {
        this.timer = time;
    }

    public Box(int x,int y){

    }
    public int getTimeLeft() {
        return timer;
    }

    public int reduceTimer() {
        return --timer;
    }
}
