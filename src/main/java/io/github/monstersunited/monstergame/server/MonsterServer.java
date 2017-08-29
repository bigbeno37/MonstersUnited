package io.github.monstersunited.monstergame.server;

import io.github.monstersunited.monstergame.client.MonsterGameHandler;
import io.github.monstersunited.monstergame.interfaces.MonsterGameInterface;
import io.github.monstersunited.monstergame.interfaces.MonsterServerInterface;
import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.objects.exceptions.InvalidAmountOfPlayersException;
import io.github.monstersunited.monstergame.objects.exceptions.TooManyPlayersException;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class MonsterServer {

    public static int amountOfPlayers;
    public static List<Player> players;
    public static List<MonsterGameInterface> clients;

    public MonsterServer() throws RemoteException {
        super();
    }

    public static void start(int amountOfPlayers) {
        MonsterServer.amountOfPlayers = amountOfPlayers;
        players = new ArrayList<>();

        try {
            Registry registry = LocateRegistry.createRegistry(3000);
            registry.rebind("server", new MonsterServerHandler());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
