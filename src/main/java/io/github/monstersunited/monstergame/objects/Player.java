package io.github.monstersunited.monstergame.objects;

import io.github.monstersunited.monstergame.server.MonsterServer;

import java.io.Serializable;

import static io.github.monstersunited.monstergame.objects.PlayerState.ALIVE;
import static io.github.monstersunited.monstergame.objects.PlayerState.DEAD;

public class Player extends Entity implements Serializable {
    private String name;
    private PlayerState state;

    public Player(String name, int x, int y) {
        this.name = name;
        super.setPosition(x, y);
        this.state = ALIVE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public boolean playerIsDead() {
        return this.state == DEAD;
    }

    public void setCorner(MonsterServer.Corner corner) {
        switch (corner) {
            case TOP_LEFT:
                super.setPosition(1, 1);
                break;
            case TOP_RIGHT:
                super.setPosition(9, 1);
                break;
            case BOTTOM_LEFT:
                super.setPosition(1, 9);
                break;
            case BOTTOM_RIGHT:
                super.setPosition(9, 9);
                break;
        }
    }
}
