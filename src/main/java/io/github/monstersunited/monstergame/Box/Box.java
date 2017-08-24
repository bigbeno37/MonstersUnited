package io.github.monstersunited.monstergame.Box;

public class Box {

    public int DEATH=1;
    public boolean ALIVE=true;
    public int PLACED = 1;
    public int HEALTH=5;

    public String NAME(String FIN, String ISHED) {
        return FIN+ISHED;

    }

    public int DeathAnimation(int HEALTH) {
        if (HEALTH<DEATH){
            ALIVE = false;
           /*playDeathAnimation();*/
            return DEATH;
        }

        return HEALTH;

    }

    public void PlayAnimationBox() {
        System.out.println("placeholder");
    }

    public int PlaceBoxes(int PLACED){
        if (PLACED>0 && PLACED <3) {
            /*PlayAnimationBox();*/
            return PLACED;
        } else {
            System.out.printf("your Box is on recharge!");
            PLACED =0;
        }

        return PLACED;
    }

    public boolean BoxRecharge(boolean RECHARGED){
        if (RECHARGED==true){
            PlaceBoxes(PLACED);
        } else {
            System.out.printf("please wait for recharge");
            RECHARGED=false;
        }

        return RECHARGED;
    }
}
