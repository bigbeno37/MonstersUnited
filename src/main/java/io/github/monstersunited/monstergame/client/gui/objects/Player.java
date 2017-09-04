package io.github.monstersunited.monstergame.client.gui.objects;

import io.github.monstersunited.monstergame.client.gui.GameObject;
import io.github.monstersunited.monstergame.client.gui.ID;
import io.github.monstersunited.monstergame.client.gui.features.Assets;

import java.awt.*;

public class Player extends GameObject {

    public Player(int x, int y, ID id){
        super(x, y, id);


    }

    public void tick(){

    }


    public void render(Graphics g){
        g.drawImage(Assets.player1,x,y,null);
    }
}
