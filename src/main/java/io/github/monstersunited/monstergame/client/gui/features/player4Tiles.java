package io.github.monstersunited.monstergame.client.gui.features;


public class player4Tiles extends TileGrid{

    //to work on
    public player4Tiles(int id) {
        super(Assets.player4,id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}

