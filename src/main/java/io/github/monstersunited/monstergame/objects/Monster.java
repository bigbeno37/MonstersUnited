package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;

// The Monster that chases the nearest player around
public class Monster extends Entity implements Serializable{
    public int monsterCanEatPlayer(int i) {
        return i+5;
    }

    public void monsterGoesToNearestPlayer() {

    }

    public Monster(int x, int y) {
        super.setPosition(x, y);
    }

    public void moveTowardsClosestPlayer(Board board) {
        // TODO
        // Move towards the closest player
        // Given is a list of Players which you need to loop through
        // and determine whoever is closest based on the board that
        // is passed in. Check for obstacles and walls too
    }
}
