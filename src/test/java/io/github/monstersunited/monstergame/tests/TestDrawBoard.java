package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.client.gui.features.SpriteSheet;
import io.github.monstersunited.monstergame.client.gui.features.getResources;
import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import static io.github.monstersunited.monstergame.client.gui.features.World.TILEHEIGHT;
import static io.github.monstersunited.monstergame.client.gui.features.World.TILEWIDTH;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.assertEquals;

public class TestDrawBoard {
    @Test
    public void TestImageResource() {
        getResources test = new getResources();
        BufferedImage path = test.loadImage("");
        BufferedImage path2 = test.loadImage("/monster-tile08.png");
        assertNotSame(path2,path);
    }

    public static BufferedImage image,image2;

    @Test
    public void TestCropping() {
        SpriteSheet p = new SpriteSheet(getResources.loadImage("/monster-tile08.png"));
        image = p.crop(0, 0, TILEWIDTH, TILEHEIGHT);
        image2 = p.crop(288, 0, TILEWIDTH, TILEHEIGHT);
        assertNotSame(image,image2);
    }
}

