package io.github.monstersunited.monstergame.objects;

import java.io.Serializable;

public class Box extends BoardPiece implements Serializable{

    public int death =1;
    public boolean alive=true;
    public int placed = 1;
    public int health=5;

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
