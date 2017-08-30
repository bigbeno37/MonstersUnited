package io.github.monstersunited.monstergame.objects.exceptions;

public class ServerFullException extends Exception {
    public ServerFullException() {
        super("Server is full!");
    }
}
