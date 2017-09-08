package io.github.monstersunited.monstergame.client.gui.features;


public class playerTiles extends TileGrid{

    //to work on
    public playerTiles(int id) {
        super(Assets.player,id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}

