package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;

public class Wall extends BoardPiece implements Serializable {
    public Wall(int x, int y) {
        super.setPosition(x, y);
    }
}
