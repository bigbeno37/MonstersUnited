package io.github.monstersunited.monstergame.objects;

import io.github.monstersunited.monstergame.objects.enums.Corner;
import io.github.monstersunited.monstergame.objects.enums.PlayerState;

import java.awt.event.KeyEvent;
import java.io.Serializable;

import static io.github.monstersunited.monstergame.objects.enums.PlayerState.ALIVE;
import static io.github.monstersunited.monstergame.objects.enums.PlayerState.DEAD;

// The player instance itself, housing position, state, velocity, and name
public class Player extends Entity implements Serializable {
    private String name;
    private PlayerState state;

    public Player(String name, int x, int y) {
        this.name = name;
        super.setPosition(x, y);
        this.state = ALIVE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state = state;
    }

    public boolean playerIsDead() {
        return this.state == DEAD;
    }

    public void setCorner(Corner corner) {
        switch (corner) {
            case TOP_LEFT:
                super.setPosition(1, 1);
                break;
            case TOP_RIGHT:
                super.setPosition(9, 1);
                break;
            case BOTTOM_LEFT:
                super.setPosition(1, 9);
                break;
            case BOTTOM_RIGHT:
                super.setPosition(9, 9);
                break;
        }
    }

    public void processMove(KeyEvent event, Board board) {
        // TODO
        // Process move and set new position accordingly
        // Make sure to check for collisions through the board passed in
        // A player cannot be on the same square as a BoardPiece, AKA
        // another Player, Monster, Box or Wall

        switch (event.getKeyCode()) {
            case KeyEvent.VK_W:
                //check if there is entity on the position that will move to
                if (board.getPieceAt(super.getX(), super.getY() - 1) instanceof Entity) {
                    System.out.println("Can't move!");
                    break;
                } else {
                    moveUp();
                }
                System.out.println("W is pressed");
                break;
            case KeyEvent.VK_S:
                if (board.getPieceAt(super.getX(), super.getY() + 1) instanceof Entity) {
                    System.out.println("Can't move!");
                    break;
                } else {
                    moveDown();
                }
                System.out.println("S is pressed");
                break;
            case KeyEvent.VK_A:
                if (board.getPieceAt(super.getX() - 1, super.getY()) instanceof Entity) {
                    System.out.println("Can't move!");
                    break;
                } else {
                    moveLeft();
                }
                System.out.println("A is pressed");
                break;
            case KeyEvent.VK_D:
                if (board.getPieceAt(super.getX() + 1, super.getY()) instanceof Entity) {
                    System.out.println("Can't move!");
                    break;
                } else {
                    moveRight();
                }
                System.out.println("D is pressed");
                break;
        }
    }

    public void moveUp() {
        super.setY(super.getY() - 1);
    }

    public void moveDown() {
        super.setY(super.getY() + 1);
    }

    public void moveLeft() {
        super.setX(super.getX() - 1);
    }

    public void moveRight() {
        super.setX(super.getX() + 1);
    }

}