package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;

public class Wall extends BoardPiece implements Serializable {

    public Wall(int x, int y) {
        collisionLocation();
    }
        //placeholder
        //insert collisions


    public int collisionLocation(){
        return 3;
    }
}
