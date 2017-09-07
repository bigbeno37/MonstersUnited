package io.github.monstersunited.monstergame.server;

import io.github.monstersunited.monstergame.interfaces.MonsterGameInterface;
import io.github.monstersunited.monstergame.objects.Board;
import io.github.monstersunited.monstergame.objects.Player;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import static io.github.monstersunited.monstergame.objects.enums.Corner.*;
import static io.github.monstersunited.monstergame.objects.enums.EntityState.DEAD;

public class MonsterServer {
    // The amount of players allowed to connect to the current
    // game lobby
    public static int maxPlayers;
    public static Board board;

    private static int fps = 60;
    private static Timer timer;

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

        // Run GameLoop every 'fps'th of a second
        timer.schedule(new GameLoop(), 0, 1000/fps);
    }

    // Reset variables back to an empty default
    public static void reset() {
        clients = new ArrayList<>();
        board = new Board();

        if (timer != null) {
            timer.cancel();
        }

        timer = new Timer();
    }

    public static boolean isThereOnlyOnePlayerLeft() {
        int playersDead = 0;

        for (Player player: board.getPlayers()) {
            // If the player is dead, add one to playersDead
            playersDead += (player.getState() == DEAD) ? 1 : 0;
        }

        if (playersDead == maxPlayers-1) {
            for (MonsterGameInterface client: clients) {
                try {
                    client.endGame();

                    return true;
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        return false;
    }
}
