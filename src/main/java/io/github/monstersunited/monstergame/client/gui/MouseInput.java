package io.github.monstersunited.monstergame.client.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {

    }


    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();



        /*
            public Rectangle joinButton = new Rectangle(Game.WIDTH / 2 - 50, 150, 100, 50);
            public Rectangle hostButton = new Rectangle(Game.WIDTH / 2 - 50, 250, 100, 50);
            public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 - 50, 350, 100, 50);
         */

        //Join Game Button
        if(mx >= Game.WIDTH / 2 - 50 && mx <= Game.WIDTH / 2 + 50){
            if(my >= 150 && my <= 200){
                Game.State = Game.STATE.GAME;
            }
        }

        //Host Game Button Not Implemented
        if(mx >= Game.WIDTH / 2 - 50 && mx <= Game.WIDTH / 2 + 50){
            if(my >= 250 && my <= 300){
                Game.State = Game.STATE.GAME;
            }
        }

        //Exit Game Button
        if(mx >= Game.WIDTH / 2 - 50 && mx <= Game.WIDTH / 2 + 50){
            if(my >= 350 && my <= 400){
                System.exit(1);


            }
        }



    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
