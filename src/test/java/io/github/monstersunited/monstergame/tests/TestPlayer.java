package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.Board;
import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.objects.exceptions.ServerFullException;
import io.github.monstersunited.monstergame.server.MonsterServer;
import io.github.monstersunited.monstergame.server.MonsterServerHandler;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;

import static org.junit.Assert.assertEquals;

public class TestPlayer {

    @Test
    public void playerMovesUp() {
        Player player = new Player("Player", 0, 0, 1);
        //initialize the position excepted
        int exceptX = player.getX();
        int exceptY;
        if (player.getY() - 1 < 0) {
            exceptY = 8;
        } else {
            exceptY = player.getY() - 1;
        }
        Board board = new Board();
        KeyEvent event = new KeyEvent(new Button(""), 0, 0, 0, KeyEvent.VK_W,'a',0);

        player.processMove(event, board);
        assertEquals(exceptX, player.getX());
        assertEquals(exceptY, player.getY());
    }

    @Test
    public void playerMoveDown() {
        Player player = new Player("Player", 0, 0, 1);
        int exceptX = player.getX();
        int exceptY;
        if (player.getY() + 1 > 8) {
            exceptY = 0;
        } else {
            exceptY = player.getY() + 1;
        }
        Board board = new Board();
        KeyEvent event = new KeyEvent(new Button(""), 0, 0, 0, KeyEvent.VK_S,'a',0);

        player.processMove(event, board);
        assertEquals(exceptX, player.getX());
        assertEquals(exceptY, player.getY());
    }

    @Test
    public void playerMoveLeft() {
        Player player = new Player("Player", 0, 0, 1);
        int exceptX;
        if (player.getX() - 1 < 0) {
            exceptX = 8;
        } else {
            exceptX = player.getX() - 1;
        }
        int exceptY = player.getY();
        Board board = new Board();
        KeyEvent event = new KeyEvent(new Button(""), 0, 0, 0, KeyEvent.VK_A,'a',0);

        player.processMove(event, board);
        assertEquals(exceptX, player.getX());
        assertEquals(exceptY, player.getY());
    }

    @Test
    public void playerMoveRight() {
        Player player = new Player("Player", 0, 0, 1);
        int exceptX;
        if (player.getX() + 1 > 8) {
            exceptX = 0;
        } else {
            exceptX = player.getX() + 1;
        }
        int exceptY = player.getY();
        Board board = new Board();
        KeyEvent event = new KeyEvent(new Button(""), 0, 0, 0, KeyEvent.VK_D,'a',0);

        player.processMove(event, board);
        assertEquals(exceptX, player.getX());
        assertEquals(exceptY, player.getY());
    }

    @Test
    public void addPlayerCorrectlySetsID() {
        MonsterServer.start(4);

        try {
            MonsterServerHandler server = new MonsterServerHandler();
            server.addPlayer("Hello");
            server.addPlayer("World!");

            assertEquals(MonsterServer.board.getAmountOfPlayers(), 2);
            assertEquals(MonsterServer.board.getPlayers().get(0).getID(), 1);
            assertEquals(MonsterServer.board.getPlayers().get(1).getID(), 2);
        } catch (RemoteException | ServerFullException e) {
            e.printStackTrace();
        }
    }
}
