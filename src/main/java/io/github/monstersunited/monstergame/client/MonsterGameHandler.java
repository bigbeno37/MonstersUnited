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

    }

    @Override
    public void beginGame(List<Player> players, Monster monster) throws RemoteException {
        // Transfer to the actual game screen, and display players and monster in center
    }

    @Override
    public void update(List<Player> players, Monster monster) throws RemoteException {
        // Update the screen
    }
}
