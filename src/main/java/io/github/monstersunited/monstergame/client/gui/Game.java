package io.github.monstersunited.monstergame.client.gui;

import io.github.monstersunited.monstergame.client.gui.features.getResources;
import io.github.monstersunited.monstergame.interfaces.MonsterServerInterface;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 425, HEIGHT = 450;
    private Thread thread;
    public boolean running = false;
    private Handler handler;


    public static MonsterServerInterface server;
    public static io.github.monstersunited.monstergame.objects.Player player;

    public Game(MonsterServerInterface server, io.github.monstersunited.monstergame.objects.Player player) {
        handler = new Handler();

        //Adding a keyinput of class KeyListener (hope that makes sense)
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Monsters United", this);



        this.server = server;
        this.player = player;
    }

    public Game() {
        handler = new Handler();
        new Window(WIDTH, HEIGHT, "Monsters United", this);


    }


    private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);

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
    private BufferedImage test;
    public void run(){

        System.out.println("Initialized Game Loop");
        //Game Loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        test = getResources.loadImage("/monster-tile08.png");
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
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(test, 0, 0,null);
        handler.render(g);

        g.dispose();
        bs.show();
    }

}