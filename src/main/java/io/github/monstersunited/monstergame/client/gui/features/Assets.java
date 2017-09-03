package io.github.monstersunited.monstergame.client.gui.features;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 32, height = 32;
    public static BufferedImage player1,player2,player3,player4,tile,box,AI;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(getResources.loadImage("/monster-tile08.png"));

        tile= sheet.crop (0,0,288,288);
        player1 =sheet.crop(288,0,width,height);
        player2 =sheet.crop(288+width,0,width,height);
        AI =sheet.crop(288+(width*2),0,width,height);
        player3 =sheet.crop(288,height,width,height);
        player4 =sheet.crop(288+width,height*2,width,height);
        box =sheet.crop(288+(width*2),height*3,width,height);

    }
}
