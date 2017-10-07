package io.github.monstersunited.monstergame.client.gui.objects;

import io.github.monstersunited.monstergame.client.gui.GameObject;
import io.github.monstersunited.monstergame.client.gui.ID;
import io.github.monstersunited.monstergame.client.gui.features.Assets;

import java.awt.*;
import java.util.Scanner;

public class Player extends GameObject {

    public Player(int x, int y, ID id) {
        super(x, y, id);
        x = 0;
        y = 0;

    }


    public void tick() {

    }

    public void render(Graphics g) {}
    //to be fixed
 /*   public void render(Graphics g) {
        int counter = 0;
        if (counter == 0) {
            x = 1;
            y = 1;
            counter++;
        } else if (counter == 1) {
            x = 20;
            y = 20;
            counter++;
        } else if (counter == 2) {
            x = 5;
            y = 5;
            counter++;
        } else if (counter == 3) {
            x = 30;
            y = 30;
            counter++;
        }

        g.drawImage(Assets.player, x, y, null);
    }*/
}
