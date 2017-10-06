package io.github.monstersunited.monstergame.interfaces;

import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.objects.exceptions.ServerFullException;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/*
 * Methods accessible in the MonsteServer by the MonsterClient,
 * implemented in MonsterServerHandler
 */

public interface MonsterServerInterface extends Remote {
    Player addPlayer(String nickname, MonsterGameInterface client) throws RemoteException, ServerFullException;

    List<Player> getAllPlayers() throws RemoteException;

    void sendInput(int event, Player currentPlayer) throws RemoteException;

    boolean isRunning() throws RemoteException;

    boolean isLobbyRunning() throws RemoteException;
}
