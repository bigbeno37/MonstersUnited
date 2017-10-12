package io.github.monstersunited.monstergame.client.gui.features;

import java.awt.image.BufferedImage;

public class Assets {
    private static final int width = 32, height = 32;
    public static BufferedImage player1, player2, player3, player4, tile, wall, monster;
    public static void init() {
        SpriteSheet sheet = new SpriteSheet(getResources.loadImage("/pixil-layer-Background.png"));

        tile = sheet.crop(0, 0, width, height);
        player1 = sheet.crop(width*2, 0, width, height);
        player2 = sheet.crop(width*3, 0, width, height);
        monster = sheet.crop(width*2, height, width, height);
        wall = sheet.crop(width, 0, width, height);
        player3 = sheet.crop(width, height, width, height);
        player4 = sheet.crop(width*2, height, width, height);
    }

}
