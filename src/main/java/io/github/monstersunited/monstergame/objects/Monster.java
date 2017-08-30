package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;

public class Monster extends Entity implements Serializable{
    public int monsterCanEatPlayer(int i) {
        return i+5;
    }

    public void monsterGoesToNearestPlayer() {

    }

    public Monster(int x, int y) {
        super.setPosition(x, y);
    }
}
