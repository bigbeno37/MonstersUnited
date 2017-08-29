package io.github.monstersunited.monstergame.client;

import io.github.monstersunited.monstergame.interfaces.MonsterGameInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MonsterGameHandler extends UnicastRemoteObject implements MonsterGameInterface {
    protected MonsterGameHandler() throws RemoteException {
        super();
    }
}
