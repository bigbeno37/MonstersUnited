package io.github.monstersunited.monstergame.client;

import io.github.monstersunited.monstergame.interfaces.MonsterGameInterface;
import io.github.monstersunited.monstergame.objects.Monster;
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
    // to the server. The players passed in have the correct positions set,
    // so do not override these positions
    @Override
    public void beginGame(List<Player> players, Monster monster) throws RemoteException {
        // TODO
        // Switch scene to showing the board and players
    }

    // Method is called only AFTER beginGame has been called, and is called
    // every 5 ticks. Passed in are the new player positions as well as the monster's
    // if they have changed
    @Override
    public void update(List<Player> players, Monster monster) throws RemoteException {
        // TODO
        // Update board with new positions of players and monster
    }
}
