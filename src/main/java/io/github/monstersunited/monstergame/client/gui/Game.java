package io.github.monstersunited.monstergame.client.gui;

import java.awt.*;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;



    public Game(){
        new Window(WIDTH, HEIGHT, "Monsters United", this);
    }

    //Starts Thread
    public synchronized void start(){
        //Initialized as new thread
        thread = new Thread(this);
        //Starting thread
        thread.start();
        running = true;
    }

    //Stops Thread
    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void run(){

        System.out.println("Yo");
        //Game Loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now -lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }

        }
        stop();
    }

    private void tick(){

    }

    private void render(){

    }

}