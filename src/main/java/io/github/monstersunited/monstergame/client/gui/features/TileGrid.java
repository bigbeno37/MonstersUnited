package io.github.monstersunited.monstergame.client.gui.features;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TileGrid {


    //Static variables here
    public static TileGrid[] tile = new TileGrid[256];
    public static TileGrid boardTile = new boardTile(0);
    public static TileGrid boxTile = new boxTile(1);
    public static TileGrid wallTile = new playerTiles(2);
    public static TileGrid playerTile = new playerTiles(3);

    //class
    public static final int TILEWIDTH = 32, TILEHEIGHT = 32;
    protected BufferedImage texture;
    protected final int id;

    public TileGrid(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tile[id] = this;
    }

    public void tick() {

    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    public boolean isSolid() {
        return false;
    }

    public int getId() {
        return id;
    }
}