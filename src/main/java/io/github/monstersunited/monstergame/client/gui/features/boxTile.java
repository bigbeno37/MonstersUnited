package io.github.monstersunited.monstergame.client.gui.features;

public class boxTile extends TileGrid{
    public boxTile(int id) {
        super(Assets.box,id);
    }
    @Override
    public boolean isSolid() {
        return true;
    }
}
