package io.github.monstersunited.monstergame.client.gui.features;

import io.github.monstersunited.monstergame.client.gui.Game;
import io.github.monstersunited.monstergame.objects.*;

import java.awt.*;

import static io.github.monstersunited.monstergame.client.gui.features.TileGrid.TILEHEIGHT;
import static io.github.monstersunited.monstergame.client.gui.features.TileGrid.TILEWIDTH;
import static io.github.monstersunited.monstergame.server.MonsterServer.board;

public class World {
    private int[][] tiles;

    public World(Board board) {
        tiles = new int[9][9];
        loadWorld(board);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {

                if (board.getPieceAt(i, j) instanceof Player) {
                    tiles[i][j] = 3;
                    g.drawImage(Assets.player, i*TILEWIDTH+64, j*TILEHEIGHT+96, null);
                    Game.player.getID();
                } else if (board.getPieceAt(i, j) instanceof Box) {
                    tiles[i][j] = 1;
                    g.drawImage(Assets.box, i*TILEWIDTH+64, j*TILEHEIGHT+96, null);

                } else if(board.getPieceAt(i, j) instanceof Wall){
                    tiles[i][j] = 2;
                    g.drawImage(Assets.wall, i*TILEWIDTH+64, j*TILEHEIGHT+96, null);

                }else {
                    tiles[i][j] = 1;
                    g.drawImage(Assets.tile, i*TILEWIDTH+64, j*TILEHEIGHT+96, null);
                }

            }
        }
    }



    public void loadWorld(Board board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getPieceAt(i, j) instanceof Player) {
                    tiles[i][j] = 3;

                } else if (board.getPieceAt(i, j) instanceof Box) {
                    tiles[i][j] = 1;
                } else if(board.getPieceAt(i, j) instanceof Wall){
                    tiles[i][j] = 2;

                }else {
                    tiles[i][j] = 0;
                }
            }
        }
    }

}
