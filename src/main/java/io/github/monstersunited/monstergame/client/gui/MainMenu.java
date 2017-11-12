package io.github.monstersunited.monstergame.client.gui;

import java.awt.*;

public class MainMenu {

    public Rectangle joinButton = new Rectangle(Game.WIDTH / 2 - 50, 150, 125, 50);
    public Rectangle hostButton = new Rectangle(Game.WIDTH / 2 - 50, 250, 125, 50);
    public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 - 50, 350, 125, 50);
    public Rectangle playButton = new Rectangle(Game.WIDTH / 2 - 50, 50, 125, 50);



    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 25);
        g.setFont(fnt0);
        g.setColor(Color.BLUE);
        g.drawString("MONSTERS UNITED", 0, 25);

        Font fnt1 = new Font("arial", Font.BOLD, 18);
        g.setFont(fnt1);
        g.setColor(Color.GRAY);
        g.drawString("Play Game",playButton.x+8,playButton.y+30);
        g2d.draw(playButton);
        g.drawString("Join Game",joinButton.x+8,joinButton.y+30);
        g2d.draw(joinButton);
        g.drawString("Host Game",hostButton.x+8,hostButton.y+30);
        g2d.draw(hostButton);
        g.drawString("Quit Game",quitButton.x+8,quitButton.y+30);
        g2d.draw(quitButton);

    }

}
