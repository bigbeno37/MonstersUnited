package io.github.monstersunited.monstergame.objects.exceptions;

public class TooManyPlayersException extends Exception {
    public TooManyPlayersException() {
        super("Too many players to start game!");
    }
}
