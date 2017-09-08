package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.Board;
import io.github.monstersunited.monstergame.objects.Entity;
import io.github.monstersunited.monstergame.objects.Player;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.junit.Assert.assertEquals;

public class TestPlayer {

    @Test
    public void playerMovesUp() {
        Player player = new Player("Player", 0, 0, 1);

        //initialize the position excepted
        int exceptX = player.getX();
        int exceptY = player.getY();

        //check player position before testing
        System.out.println("Checking the origin player position");
        assertEquals(exceptX, player.getX());
        assertEquals(exceptY, player.getY());

        //initialize board
        Board board = new Board();

        //update exceptY, check if there are some pieces on the position that player moving to
        //if so, reject to move player
        if (player.getY() - 1 < 0) {
            //if the position that player going to move to has something on is already
            //keep the exceptY as where player standing at the moment
            if (board.getPieceAt(player.getX(), 8) instanceof Entity) {
                System.out.println("The position player move to has something on it already! Invalid Move");
                exceptY = player.getY();
            } else {
                exceptY = 8;
            }
        } else {
            exceptY = player.getY() - 1;
        }

        KeyEvent event = new KeyEvent(new Button(""), 0, 0, 0, KeyEvent.VK_W, 'a', 0);

        player.processMove(event, board);
        assertEquals(exceptX, player.getX());
        assertEquals(exceptY, player.getY());
    }

    @Test
    public void playerMoveDown() {
        Player player = new Player("Player", 0, 0, 1);
        int exceptX = player.getX();
        int exceptY = player.getY();

        //check player position before testing
        System.out.println("Checking the origin player position");
        assertEquals(exceptX, player.getX());
        assertEquals(exceptY, player.getY());

        Board board = new Board();
        if (player.getY() + 1 > 8) {
            if (board.getPieceAt(player.getX(), 0) instanceof Entity) {
                System.out.println("The position player move to has something on it already! Invalid Move");
                exceptY = player.getY();
            } else {
                exceptY = 0;
            }
        } else {
            exceptY = player.getY() + 1;
        }
        KeyEvent event = new KeyEvent(new Button(""), 0, 0, 0, KeyEvent.VK_S, 'a', 0);

        player.processMove(event, board);
        assertEquals(exceptX, player.getX());
        assertEquals(exceptY, player.getY());
    }

    @Test
    public void playerMoveLeft() {
        Player player = new Player("Player", 0, 0, 1);
        int exceptX = player.getX();
        int exceptY = player.getY();

        //check player position before testing
        System.out.println("Checking the origin player position");
        assertEquals(exceptX, player.getX());
        assertEquals(exceptY, player.getY());

        Board board = new Board();
        if (player.getX() - 1 < 0) {
            if (board.getPieceAt(8, player.getY()) instanceof Entity) {
                System.out.println("The position player move to has something on it already! Invalid Move");
                exceptX = player.getX();
            } else {
                exceptX = 8;
            }
        } else {
            exceptX = player.getX() - 1;
        }
        KeyEvent event = new KeyEvent(new Button(""), 0, 0, 0, KeyEvent.VK_A, 'a', 0);

        player.processMove(event, board);
        assertEquals(exceptX, player.getX());
        assertEquals(exceptY, player.getY());
    }

    @Test
    public void playerMoveRight() {
        Player player = new Player("Player", 0, 0, 1);
        int exceptX = player.getX();
        int exceptY = player.getY();

        //check player position before testing
        System.out.println("Checking the origin player position");
        assertEquals(exceptX, player.getX());
        assertEquals(exceptY, player.getY());

        Board board = new Board();
        if (player.getX() + 1 > 8) {
            if (board.getPieceAt(0, player.getY()) instanceof Entity) {
                System.out.println("The position player move to has something on it already! Invalid Move");
                exceptX = player.getX();
            } else {
                exceptX = 0;
            }
        } else {
            exceptX = player.getX() + 1;
        }
        KeyEvent event = new KeyEvent(new Button(""), 0, 0, 0, KeyEvent.VK_D, 'a', 0);

        player.processMove(event, board);
        assertEquals(exceptX, player.getX());
        assertEquals(exceptY, player.getY());
    }
}
