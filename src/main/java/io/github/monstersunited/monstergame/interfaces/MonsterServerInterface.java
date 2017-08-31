package io.github.monstersunited.monstergame.interfaces;

import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.objects.exceptions.ServerFullException;

import java.awt.event.KeyEvent;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MonsterServerInterface extends Remote {
    void addClient(MonsterGameInterface client) throws RemoteException;

    Player addPlayer(String nickname) throws RemoteException, ServerFullException;

    List<Player> getAllPlayers() throws RemoteException;

    void sendInput(KeyEvent event, Player currentPlayer) throws RemoteException;
}
