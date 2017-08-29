package io.github.monstersunited.monstergame.client.gui;

import io.github.monstersunited.monstergame.client.gui.objects.Player;
import io.github.monstersunited.monstergame.server.MonsterServer;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    public boolean running = false;
    private Handler handler;



    public Game(){
        MonsterServer.start(4);
        handler = new Handler();
        new Window(WIDTH, HEIGHT, "Monsters United", this);

        //Temporary Object Placement
        handler.addObject(new Player(WIDTH/2-16,HEIGHT/2-16,ID.Player));
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

        System.out.println("Initialized Game Loop");
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
        //This should be the GM equivelant of "Step"
        handler.tick();

    }

    private void render(){
        //This should be the GM equivelant of "Draw"

        //The amount of frames drawn ahead of time
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        //Background
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

}