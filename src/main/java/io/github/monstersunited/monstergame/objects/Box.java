package io.github.monstersunited.monstergame.objects;

import io.github.monstersunited.monstergame.client.gui.features.Assets;
import io.github.monstersunited.monstergame.client.gui.features.TileGrid;

import java.awt.*;
import java.io.Serializable;

public class Box extends BoardPiece implements Serializable{

    public int death =1;
    public boolean alive=true;
    public int placed = 1;
    public int health=5;
    protected Rectangle bounds;
    public int x,y,width,height;


    public Box(int x, int y,int width,int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        bounds = new Rectangle(0,0,width,height);

        bounds.x=16;
        bounds.y = 16;

        bounds.width=32;
        bounds.height=32;
    }

    public void render(){

    }

    public String name(String fin, String ished) {
        return fin+ished;

    }

    public int deathAnimation(int health) {
        if (health< death){
            alive = false;
           /*playDeathAnimation();*/
            return death;
        }

        return health;

    }

    public void playAnimationBox() {
        System.out.println("placeholder");
    }

    public int placeBoxes(int placed){
        if (placed>0 && placed <3) {
            /*playAnimationBox();*/
            return placed;
        } else {
            System.out.printf("your Box is on recharge!");
            placed =0;
        }

        return placed;
    }

    public boolean boxRecharge(boolean recharged){
        if (recharged==true){
            placeBoxes(placed);
        } else {
            System.out.printf("please wait for recharge");
            recharged=false;
        }

        return recharged;
    }
}
