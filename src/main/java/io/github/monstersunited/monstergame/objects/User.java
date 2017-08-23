package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;

public class User implements Serializable{
    public String username;

    public User(String username) {
        this.username = username;
    }
}
