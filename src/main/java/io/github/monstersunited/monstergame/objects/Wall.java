package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;

public class Wall extends BoardPiece implements Serializable {



    public int collisionLocation(){
        return 3;
    }
}
