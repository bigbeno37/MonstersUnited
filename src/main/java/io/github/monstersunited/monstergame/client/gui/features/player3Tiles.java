package io.github.monstersunited.monstergame.client.gui.features;


public class player3Tiles extends TileGrid{

    //to work on
    public player3Tiles(int id) {
        super(Assets.player3,id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}

