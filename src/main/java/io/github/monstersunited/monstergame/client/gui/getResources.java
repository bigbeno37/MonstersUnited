package io.github.monstersunited.monstergame.client.gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class getResources {
    public String resource;
    public int width;
    public int height;

    public getResources(String resource) {
        BufferedImage image = null;

        try {
            image = ImageIO.read(getResources.class.getResource(resource));
        } catch (IOException e){
            e.printStackTrace();
        }
        this.resource = resource;
        this.width = image.getWidth();
        this.height = image.getHeight();

    }
}
