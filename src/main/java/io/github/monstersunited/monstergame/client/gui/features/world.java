package io.github.monstersunited.monstergame.client.gui.features;

import io.github.monstersunited.monstergame.objects.Board;

import java.awt.*;

import static io.github.monstersunited.monstergame.client.gui.features.TileGrid.TILEHEIGHT;
import static io.github.monstersunited.monstergame.client.gui.features.TileGrid.TILEWIDTH;

public class world {
    private int[][] tiles;


    public world(Board board){
        tiles = new int[9][9];
        loadworld(board);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                tiles[j][i] = 0;
                getTile(i,j).render(g,i*TILEWIDTH,j*TILEHEIGHT);
            }
        }
    }

    public TileGrid getTile(int x, int y) {
        /*this is just to prevent errors temporarily*/
        if (x<0||y>0||x>=9||y>=9){
            return TileGrid.boardTile;
        }

        TileGrid t = TileGrid.tile[tiles[x][y]];
        if (t==null){
            return TileGrid.boardTile;
        }
        return t;
    }
    public void loadworld(Board board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                    tiles[i][j] = 0;
            }
        }
    }

}
