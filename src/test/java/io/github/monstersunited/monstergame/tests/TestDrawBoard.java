package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.client.gui.features.TileGrid;
import io.github.monstersunited.monstergame.client.gui.features.boxTile;
import io.github.monstersunited.monstergame.client.gui.features.getResources;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

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

}

