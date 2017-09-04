package io.github.monstersunited.monstergame.client.gui;

import io.github.monstersunited.monstergame.objects.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;

public class KeyInput extends KeyAdapter{

    private Handler handler;

    public KeyInput(Handler handler){
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e){
        //Keycode for pressed key
        try {
            Game.server.sendInput(e, Game.player);
        } catch (RemoteException e1) {
            e1.printStackTrace();
        }
    }

    public void keyReleased(KeyEvent e){
        //Keycode for released key
        int key = e.getKeyCode();

    }

}
