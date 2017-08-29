package io.github.monstersunited.monstergame.interfaces;

import io.github.monstersunited.monstergame.client.MonsterGameHandler;
import io.github.monstersunited.monstergame.objects.Player;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MonsterServerInterface extends Remote {
    void initialise(MonsterGameHandler monsterGameHandler) throws RemoteException;

    void newUser(String nickname) throws RemoteException;

    List<Player> getAllUsers() throws RemoteException;
}
