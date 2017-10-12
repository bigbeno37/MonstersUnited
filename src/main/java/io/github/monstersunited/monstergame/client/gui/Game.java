package io.github.monstersunited.monstergame.client.gui;

import io.github.monstersunited.monstergame.client.gui.features.Assets;
import io.github.monstersunited.monstergame.client.gui.features.World;
import io.github.monstersunited.monstergame.client.gui.objects.Player;
import io.github.monstersunited.monstergame.interfaces.MonsterServerInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

import static io.github.monstersunited.monstergame.client.gui.Game.STATE.EMPTY;
import static io.github.monstersunited.monstergame.server.MonsterServer.board;


public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = 480;
    private Thread thread;
    public boolean running = false;
    private Handler handler;
    private World map;
    private MainMenu mainMenu;
    public enum STATE{
        MENU, GAME, NICK, PLAYER, IP,HOST,EMPTY,JOIN
    };

    public static STATE State = STATE.MENU;


    public static MonsterServerInterface server;
    public static io.github.monstersunited.monstergame.objects.Player player;

    public Game(MonsterServerInterface server, io.github.monstersunited.monstergame.objects.Player player) {
        handler = new Handler();
        map = new World(board);
        mainMenu = new MainMenu();
        new Window(WIDTH, HEIGHT, "Monsters United", this);
        /*
        //Temporary Object Placement
        handler.addObject(new Player(WIDTH / 2 - 16, HEIGHT / 2 - 16, ID.Player));
        */
        //Adds Mouse
        this.addMouseListener(new MouseInput());
        this.addKeyListener(new KeyInput(handler));


        this.server = server;
        this.player = player;

    }

    public Game() {
        handler = new Handler();
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
            while(delta >=1){
                tick();
                delta--;
            }
            if(running) {
                render();
                HostGameSelection();
            }
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
        if(State == STATE.GAME){
            map.tick();
            //This should be the GM equivelant of "Step"
            handler.tick();
        }


    }

    public void HostGameSelection() {

        if (State == STATE.JOIN) {
            UserInput p  = new UserInput();
            p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            p.setSize(300,150);
            p.setTitle("Join");
            p.setVisible(true);
            State = EMPTY;
        }

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
        if (State == STATE.GAME) {
            //Background
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());

            Font fnt0 = new Font("arial", Font.BOLD, 25);
            g.setFont(fnt0);
            g.setColor(Color.BLUE);
            g.drawString("PPPPLACEHOLDER", 208, 25);

            Font fnt1 = new Font("times", Font.PLAIN, 15);
            g.setFont(fnt1);
            g.setColor(Color.WHITE);
            g.drawString("Connected Players", 480, 96);

            Font fnt2 = new Font("times", Font.PLAIN, 20);
            g.setFont(fnt2);
            g.drawString("Server Condition:", 64, 424);






            map.render(g);

            handler.render(g);
            g.dispose();
            bs.show();
        } else if(State == STATE.MENU){
            //Background
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());


            mainMenu.render(g);
            g.dispose();
            bs.show();

        } else if (State == State.HOST) {
            //placeholder
        }

    }

}