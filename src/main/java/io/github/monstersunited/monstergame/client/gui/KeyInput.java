package io.github.monstersunited.monstergame.client.gui;

import io.github.monstersunited.monstergame.objects.Player;



import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;


public class KeyInput extends KeyAdapter{

    Handler handler;

    public KeyInput(Handler handler){

        this.handler = handler;
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE){
            System.exit(1);
        }
    }


    public void keyReleased(KeyEvent e){
        System.out.println("Key was entered!");

        //Keycode for released key
        try {
            Game.server.sendInput(e, Game.player);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }

    }

}
