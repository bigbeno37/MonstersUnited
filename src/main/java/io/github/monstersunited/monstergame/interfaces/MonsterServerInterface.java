package io.github.monstersunited.monstergame.interfaces;

import io.github.monstersunited.monstergame.objects.Player;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MonsterServerInterface extends Remote {
    void initialise(MonsterGameInterface client) throws RemoteException;

    void newPlayer(String nickname) throws RemoteException;

    List<Player> getAllPlayers() throws RemoteException;
}
