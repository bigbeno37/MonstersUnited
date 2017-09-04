package io.github.monstersunited.monstergame.client.gui;

import io.github.monstersunited.monstergame.client.gui.features.Assets;
import io.github.monstersunited.monstergame.client.gui.objects.Player;
import io.github.monstersunited.monstergame.interfaces.MonsterServerInterface;
import io.github.monstersunited.monstergame.objects.Board;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 295, HEIGHT = WIDTH+28;
    private Thread thread;
    public boolean running = false;
    private Handler handler;
    private Board map;


    private MonsterServerInterface server;
    private io.github.monstersunited.monstergame.objects.Player player;

    public Game(MonsterServerInterface server, io.github.monstersunited.monstergame.objects.Player player) {
        handler = new Handler();
        map = new Board();
        new Window(WIDTH, HEIGHT, "Monsters United", this);

        //Temporary Object Placement
        handler.addObject(new Player(WIDTH / 2 - 16, HEIGHT / 2 - 16, ID.Player));

        this.server = server;
        this.player = player;
    }

    public Game() {
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
        Assets.init();
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
        map.tick();
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
        map.render(g);

        handler.render(g);
        g.dispose();
        bs.show();
    }

}