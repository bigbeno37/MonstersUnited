package io.github.monstersunited.monstergame.client.gui.features;

import java.util.ArrayList;

public class playerTiles extends TileGrid{

    //to work on
    public playerTiles(int id) {
        super(Assets.player1,id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}

