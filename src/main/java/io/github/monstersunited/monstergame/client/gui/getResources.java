package io.github.monstersunited.monstergame.client.gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class getResources {

    public static BufferedImage loadImage(String resource) {
        try{
            return ImageIO.read(getResources.class.getResource(resource));
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
