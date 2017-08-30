package io.github.monstersunited.monstergame.server;

import io.github.monstersunited.monstergame.interfaces.MonsterGameInterface;
import io.github.monstersunited.monstergame.objects.Monster;
import io.github.monstersunited.monstergame.objects.Player;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import static io.github.monstersunited.monstergame.server.MonsterServer.Corner.*;

public class MonsterServer {

    public static int amountOfPlayers;
    public static List<Player> players;
    public static Monster monster;
    public static List<MonsterGameInterface> clients;

    public MonsterServer() throws RemoteException {
        super();
    }

    public static void start(int amountOfPlayers) {
        MonsterServer.amountOfPlayers = amountOfPlayers;
        players = new ArrayList<>();
        clients = new ArrayList<>();
        monster = new Monster(5, 5);

        try {
            Registry registry = LocateRegistry.createRegistry(3000);
            registry.rebind("server", new MonsterServerHandler());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public enum Corner {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
    }

    public static void beginGame() {

        boolean topLeft = false, topRight = false,
                bottomLeft = false;

        for (Player player: players) {

            if (!topLeft) {

                player.setCorner(TOP_LEFT);
                topLeft = true;

            } else if (!topRight) {

                player.setCorner(TOP_RIGHT);
                topRight = true;

            } else if (!bottomLeft) {

                player.setCorner(BOTTOM_LEFT);
                bottomLeft = true;

            } else {
                player.setCorner(BOTTOM_RIGHT);
            }

            MonsterServer.players.remove(player);
            MonsterServer.players.add(player);
        }

        for (MonsterGameInterface client: MonsterServer.clients) {

            try {
                client.beginGame(players, monster);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        MonsterServer.gameLoop();
    }

    private static void gameLoop() {
        // TODO
        // Every 5 ticks
        for (MonsterGameInterface client: MonsterServer.clients) {
            try {
                client.update(players, monster);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
