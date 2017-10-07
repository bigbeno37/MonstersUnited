package io.github.monstersunited.monstergame.client.gui.features;


public class player1Tiles extends TileGrid{

    //to work on
    public player1Tiles(int id) {
        super(Assets.player1,id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}

