package io.github.monstersunited.monstergame.interfaces;

import io.github.monstersunited.monstergame.objects.Monster;
import io.github.monstersunited.monstergame.objects.Player;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/*
 * Methods accessible in the MonsterClient by the MonsterServer,
 * implemented by MonsterGameHandler
 */

public interface MonsterGameInterface extends Remote {
    void refreshPlayerList(List<Player> players) throws RemoteException;

    void beginGame(List<Player> players, Monster monster) throws RemoteException;

    void update(List<Player> players, Monster monster) throws RemoteException;
}
