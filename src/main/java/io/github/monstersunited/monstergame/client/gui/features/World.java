package io.github.monstersunited.monstergame.client.gui.features;

import io.github.monstersunited.monstergame.client.gui.Game;
import io.github.monstersunited.monstergame.objects.*;

import java.awt.*;

import static io.github.monstersunited.monstergame.client.gui.features.TileGrid.TILEHEIGHT;
import static io.github.monstersunited.monstergame.client.gui.features.TileGrid.TILEWIDTH;
import static io.github.monstersunited.monstergame.server.MonsterServer.board;
import io.github.monstersunited.monstergame.objects.Player;
public class World {
    Player player1 = new Player("jaia",1*TILEWIDTH,1*TILEHEIGHT,3);
    Player player2 = new Player("Tiff",1*TILEWIDTH,9*TILEHEIGHT,4);
    Player player3 = new Player("Urio",9*TILEWIDTH,1*TILEHEIGHT,5);
    Player player4 = new Player("Raein",9*TILEWIDTH,9*TILEHEIGHT,6);
    Monster monster = new Monster(5*TILEWIDTH,5*TILEHEIGHT);
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
                        g.drawImage(Assets.player1, i * TILEWIDTH + 64, j * TILEHEIGHT + 96, null);
                    } else if (board.getPieceAt(i, j) instanceof Player) {
                        tiles[i][j] = 4;
                        g.drawImage(Assets.player2, i * TILEWIDTH + 64, j * TILEHEIGHT + 96, null);
                    } else if (board.getPieceAt(i, j) instanceof Player) {
                        tiles[i][j] = 5;
                        g.drawImage(Assets.player3, i * TILEWIDTH + 64, j * TILEHEIGHT + 96, null);
                    } else if (board.getPieceAt(i, j) instanceof Player) {
                        tiles[i][j] = 6;
                        g.drawImage(Assets.player4, i * TILEWIDTH + 64, j * TILEHEIGHT + 96, null);
                    }
                    else if (board.getPieceAt(i, j) instanceof Monster) {
                        tiles[i][j] = 7;
                        g.drawImage(Assets.monster, i * TILEWIDTH + 64, j * TILEHEIGHT + 96, null);
                    }
                    else if (board.getPieceAt(i, j) instanceof Box) {
                        tiles[i][j] = 1;
                        g.drawImage(Assets.box, i * TILEWIDTH + 64, j * TILEHEIGHT + 96, null);
                    }
                    else if (board.getPieceAt(i, j) instanceof Wall) {
                        tiles[i][j] = 2;
                        g.drawImage(Assets.wall, i * TILEWIDTH + 64, j * TILEHEIGHT + 96, null);
                    }
                    else {
                        tiles[i][j] = 0;
                        g.drawImage(Assets.tile, i * TILEWIDTH + 64, j * TILEHEIGHT + 96, null);
                    }
                }
            }
    }



    public void loadWorld(Board board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board.getPieceAt(i, j) instanceof Player) {
                    tiles[i][j] = 3;

                } else if (board.getPieceAt(i, j) instanceof Player) {
                    tiles[i][j] = 4;

                } else if (board.getPieceAt(i, j) instanceof Player) {
                    tiles[i][j] = 5;

                } else if (board.getPieceAt(i, j) instanceof Player) {
                    tiles[i][j] = 6;

                } else if (board.getPieceAt(i, j) instanceof Monster) {
                    tiles[i][j] = 7;

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
