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
        super.setPosition(corner.x, corner.y);
    }

    public void processMove(KeyEvent event, Board board) {
        switch (event.getKeyCode()) {
            case KeyEvent.VK_W:
                //check if there is entity on the position that will move to
                if (!(super.getY() - 1 < 0)) {
                    //if position that player moving to has something, stop player moving to that position
                    if (board.getPieceAt(super.getX(), super.getY() - 1) instanceof Entity) {
                        System.out.println("Can't move!");
                        break;
                    } else {
                        //move up 1 unit
                        moveUp();
                    }
                } else {
                    //wrap player position
                    super.setY(8);
                }
                System.out.println("W is pressed");
                break;
            case KeyEvent.VK_S:
                if (!(super.getY() + 1 > 8)) {
                    if (board.getPieceAt(super.getX(), super.getY() + 1) instanceof Entity) {
                        System.out.println("Can't move!");
                        break;
                    } else {
                        //move down 1 unit
                        moveDown();
                    }
                } else {
                    super.setY(0);
                }
                System.out.println("S is pressed");
                break;
            case KeyEvent.VK_A:
                if (!(super.getX() - 1 < 0)) {
                    if (board.getPieceAt(super.getX() - 1, super.getY()) instanceof Entity) {
                        System.out.println("Can't move!");
                        break;
                    } else {
                        moveLeft();
                    }
                } else {
                    super.setX(8);
                }
                System.out.println("A is pressed");
                break;
            case KeyEvent.VK_D:
                if (!(super.getX() + 1 > 8)) {
                    if (board.getPieceAt(super.getX() + 1, super.getY()) instanceof Entity) {
                        System.out.println("Can't move!");
                        break;
                    } else {
                        moveRight();
                    }
                } else {
                    super.setX(0);
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