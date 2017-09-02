package io.github.monstersunited.monstergame.server;

import io.github.monstersunited.monstergame.interfaces.MonsterGameInterface;
import io.github.monstersunited.monstergame.objects.Board;
import io.github.monstersunited.monstergame.objects.Player;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import static io.github.monstersunited.monstergame.objects.enums.Corner.*;

public class MonsterServer {
    // The amount of players allowed to connect to the current
    // game lobby
    public static int maxPlayers;
    public static Board board;

    // Currently connected clients; used for callbacks through RMI
    public static List<MonsterGameInterface> clients;

    public static void start(int amountOfPlayers) {
        MonsterServer.maxPlayers = amountOfPlayers;

        // Set the players, monster and board to default values
        reset();

        try {
            Registry registry = LocateRegistry.createRegistry(3000);
            registry.rebind("server", new MonsterServerHandler());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void beginGame() {
        // Go through each player in the players list and set them
        // in each corner
        boolean topLeft = false, topRight = false,
                bottomLeft = false;

        for (Player player: board.getPlayers()) {

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
        }

        // Once the positions of players have been initialised, call
        // the beginGame method in all clients to signal the switch
        // to the core game
        for (MonsterGameInterface client: clients) {
            // Update the board with the positions of the players
            // reflected in the board itself
            board.update();

            try {
                client.beginGame(board);
            } catch (RemoteException e) {
                e.printStackTrace();
            }

        }

        // Enter the actual loop of the game
        gameLoop();
    }

    private static void gameLoop() {
        // TODO
        // Every 5 ticks

        // Every loop, the monster should move towards the closest
        // player, and each player have their position updated
        // according to what direction they input
        board.getMonster().moveTowardsClosestPlayer(board);
        board.update();

        // Afterwards, send the new positions to the clients
        for (MonsterGameInterface client: clients) {
            try {
                client.update(board);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    // Reset variables back to an empty default
    public static void reset() {
        clients = new ArrayList<>();
        board = new Board();
    }
}
