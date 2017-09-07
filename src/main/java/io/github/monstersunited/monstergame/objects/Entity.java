package io.github.monstersunited.monstergame.objects;

import io.github.monstersunited.monstergame.objects.enums.EntityState;

import java.io.Serializable;

// An Entity is a BoardPiece that can move and has its own behaviours,
// thus the inclusion of velocity as seen
public abstract class Entity extends BoardPiece implements Serializable{
    private EntityState state;

    public EntityState getState() {
        return state;
    }

    public void setState(EntityState state) {
        this.state = state;
    }
}
