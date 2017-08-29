package io.github.monstersunited.monstergame.server;

import io.github.monstersunited.monstergame.client.MonsterGameHandler;
import io.github.monstersunited.monstergame.interfaces.MonsterGameInterface;
import io.github.monstersunited.monstergame.interfaces.MonsterServerInterface;
import io.github.monstersunited.monstergame.objects.Player;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MonsterServerHandler extends UnicastRemoteObject implements MonsterServerInterface {
    public MonsterServerHandler() throws RemoteException {
        super();
    }

    @Override
    public void initialise(MonsterGameInterface client) throws RemoteException {
        MonsterServer.clients.add(client);
    }

    @Override
    public void newPlayer(String nickname) throws RemoteException {
        MonsterServer.players.add(new Player(nickname));
    }

    @Override
    public List<Player> getAllPlayers() throws RemoteException {
        return MonsterServer.players;
    }
}
