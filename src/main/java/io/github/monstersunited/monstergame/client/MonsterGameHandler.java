package io.github.monstersunited.monstergame.client;

import io.github.monstersunited.monstergame.client.gui.features.world;
import io.github.monstersunited.monstergame.interfaces.MonsterGameInterface;
import io.github.monstersunited.monstergame.objects.Board;
import io.github.monstersunited.monstergame.objects.Player;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MonsterGameHandler extends UnicastRemoteObject implements MonsterGameInterface {
    protected MonsterGameHandler() throws RemoteException {
        super();
    }

    // Method is called every time a new player connects to server
    @Override
    public void refreshPlayerList(List<Player> players) throws RemoteException {
        // TODO
        // Refresh player list on client
    }

    // Method is called when the designated amount of players have connected
    // to the server.
    @Override
    public void beginGame(Board board) throws RemoteException {
        // TODO
        // Switch scene to showing the board and players
    }

    // Method is called only AFTER beginGame has been called, and is called
    // every 5 ticks.
    @Override
    public void update(Board board) throws RemoteException {
        // TODO
        new world(board);
        // Update board with new positions of players and monster
    }

    // Method is called once all players but one are eaten
    @Override
    public void endGame() throws RemoteException {
        // TODO
        // Display end game screen and go back to main menu
    }
}
