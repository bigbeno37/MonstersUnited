package io.github.monstersunited.monstergame.client.gui.features;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class getResources {

    public static BufferedImage loadImage(String resource) {
        try{
            return ImageIO.read(getResources.class.getResourceAsStream(resource));
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(getResources.class.getResource(resource));
            System.exit(1);

        }
        return null;
    }
}
