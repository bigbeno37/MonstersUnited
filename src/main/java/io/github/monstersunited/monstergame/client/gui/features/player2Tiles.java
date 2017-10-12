package io.github.monstersunited.monstergame.client.gui.features;


public class player2Tiles extends TileGrid{

    //to work on
    public player2Tiles(int id) {
        super(Assets.player2,id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}

