package io.github.monstersunited.monstergame.interfaces;

import io.github.monstersunited.monstergame.objects.Player;

import java.awt.event.KeyEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MonsterServerInterface extends Remote {
    void initialise(MonsterGameInterface client) throws RemoteException;

    Player newPlayer(String nickname) throws RemoteException;

    List<Player> getAllPlayers() throws RemoteException;

    void sendInput(KeyEvent event, Player currentPlayer) throws RemoteException;
}
