package io.github.monstersunited.monstergame.client;

import io.github.monstersunited.monstergame.client.gui.Game;
import io.github.monstersunited.monstergame.interfaces.MonsterServerInterface;
import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.objects.exceptions.ServerFullException;
import io.github.monstersunited.monstergame.server.MonsterServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MonsterGame {
    // Where everything begins. Here the user can choose whether to
    // create a new lobby, or join one
    public static void main(String[] args) {
        System.out.println("Client started!");

        boolean createGame = State.createOrJoinGame();

        // If the user chose to create a game...
        if (createGame) {
            createGame();
        } else {
            joinGame();
        }
    }

    // Display a field to enter a server address, and attempt
    // to connect to a lobby if it exists
    private static void joinGame() {
        String[] address = State.enterServerAddress();

        joinLobby(address[0], Integer.parseInt(address[1]));
    }

    // Create a lobby and decide how many players should be
    // allowed to play
    private static void createGame() {
        int amountOfPlayers = State.getAmountOfPlayers();

        // Initialise the RMI Registry and other variables
        // on the server
        MonsterServer.start(amountOfPlayers);

        // Join the locally hosted server
        joinLobby("localhost", 3000);
    }

    // Connect to a lobby if it exists on serverAddress:port
    private static void joinLobby(String serverAddress, int port) {
        try {
            // Gain access to the server with RMI
            MonsterServerInterface server = (MonsterServerInterface) LocateRegistry.getRegistry(serverAddress, port).lookup("server");

            // Add callbacks for use with the Observer pattern
            server.addClient(new MonsterGameHandler());

            String nickname = State.getNickname();
            Player player = server.addPlayer(nickname);

            // TODO
            // Temporary, we need to start the client MUCH earlier
            // See above
            new Game(server, player);

            State.preGameScreen(server);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();

            joinGame();
        } catch (ServerFullException e) {
            System.out.println("Lobby is full!");

            joinGame();
        }
    }

}
