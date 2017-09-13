package io.github.monstersunited.monstergame.client.gui.features;

public class wallTile extends TileGrid{
        public wallTile(int id) {
            super(Assets.wall,id);
        }
        @Override
        public boolean isSolid() {
            return true;
        }
}
