package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;

public class Player implements Serializable {
    public String name;

    public Player(String name) {
        this.name = name;
    }
}
