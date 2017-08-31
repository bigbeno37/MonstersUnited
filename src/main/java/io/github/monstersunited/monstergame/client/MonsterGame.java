package io.github.monstersunited.monstergame.client;

import io.github.monstersunited.monstergame.client.gui.Game;
import io.github.monstersunited.monstergame.interfaces.MonsterServerInterface;
import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.objects.exceptions.ServerFullException;
import io.github.monstersunited.monstergame.server.MonsterServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

class MonsterGame {
    public static void main(String[] args) {
        System.out.println("Client started!");

        // TODO
        // Display two buttons; one to create a new game
        // and the other to join a game

        // TODO
        // Replace with user choice
        boolean createGame = true;

        if (createGame) {
            createGame();
        } else {
            joinGame();
        }
    }

    private static void joinGame() {
        // TODO
        // Get from User
        String serverAddress = "localhost";
        int port = 3000;

        joinLobby(serverAddress, port);
    }

    private static void createGame() {

        int amountOfPlayers = State.getAmountOfPlayers();

        MonsterServer.start(amountOfPlayers);

        joinLobby("localhost", 3000);
    }

    private static void joinLobby(String serverAddress, int port) {
        try {
            MonsterServerInterface server = (MonsterServerInterface) LocateRegistry.getRegistry(serverAddress, port).lookup("server");

            server.addClient(new MonsterGameHandler());

            String nickname = State.getNickname();
            Player player = server.addPlayer(nickname);

            new Game(server, player);

            State.preGameScreen(server);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        } catch (ServerFullException e) {
            System.out.println("Lobby is full!");
        }
    }

}
