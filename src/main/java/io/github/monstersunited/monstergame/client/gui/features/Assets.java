package io.github.monstersunited.monstergame.client.gui.features;


import sun.awt.image.BufferedImageDevice;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 32, height = 32;
    public static BufferedImage player1, player2, player3, player4, tile, box, AI, player;
    private static int counter;

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(getResources.loadImage("/monster-tile08.png"));

        tile = sheet.crop(0, 0, width, height);
        player1 = sheet.crop(288, 0, width, height);
        player2 = sheet.crop(288 + width, 0, width, height);
        AI = sheet.crop(288 + (width * 2), 0, width, height);
        player3 = sheet.crop(288, height, width, height);
        player4 = sheet.crop(288 + width, height, width, height);
        box = sheet.crop(288 + (width * 2), height, width, height);

    }

    public static void initPlayer() {
        SpriteSheet sheet = new SpriteSheet(getResources.loadImage("/monster-tile08.png"));
        if (counter == 0) {
            player = sheet.crop(288, 0, width, height);
            counter++;
        } else if (counter == 1) {
            player = sheet.crop(288 + width, 0, width, height);
            counter++;
        } else if (counter == 2) {
            player = sheet.crop(288, height, width, height);
            counter++;
        } else if (counter == 3) {
            player = sheet.crop(288 + width, height, width, height);
            counter++;
        }
    }

}
