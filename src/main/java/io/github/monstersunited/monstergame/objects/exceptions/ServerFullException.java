package io.github.monstersunited.monstergame.objects.exceptions;

// Thrown when a player attempts to connect to the server
// when the maximum amount of players are connected already
public class ServerFullException extends Exception {
    public ServerFullException() {
        super("Server is full!");
    }
}
