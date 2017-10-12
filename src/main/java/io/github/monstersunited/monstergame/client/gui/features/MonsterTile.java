package io.github.monstersunited.monstergame.client.gui.features;


public class MonsterTile extends TileGrid{

    //to work on
    public MonsterTile(int id) {
        super(Assets.monster,id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}

