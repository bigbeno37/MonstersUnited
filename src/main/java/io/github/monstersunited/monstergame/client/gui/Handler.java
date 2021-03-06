package io.github.monstersunited.monstergame.client.gui;

import io.github.monstersunited.monstergame.client.gui.features.World;
import io.github.monstersunited.monstergame.objects.Player;

import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.awt.Graphics;

public class Handler {
    //Loops through all objects in-game
    //Updates, followed by render

    //Linked List of all gameobjects to be handled
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    private World map;
    public void setWorld(World map){
        this.map=map;
    }
    public World getWorld(){
        return map;
    }

    public void tick(){
        for (int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    //Adding and removing GameObject from LinkedList
    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }
}

