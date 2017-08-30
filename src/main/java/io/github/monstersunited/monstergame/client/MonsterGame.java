package io.github.monstersunited.monstergame.client;

import io.github.monstersunited.monstergame.client.gui.Game;
import io.github.monstersunited.monstergame.interfaces.MonsterServerInterface;
import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.server.MonsterServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

class MonsterGame {
    public static void main(String[] args) {
        System.out.println("Client started!");

        MonsterServer.start(4);

        // TODO
        // Display two buttons; one to create a new game
        // and the other to join a game

        // TODO
        // Replace with user choice
        boolean createGame = false;

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

        try {
            MonsterServerInterface server = (MonsterServerInterface) LocateRegistry.getRegistry(serverAddress, port).lookup("server");

            server.initialise(new MonsterGameHandler());

            String nickname = State.getNickname();

            Player player = server.newPlayer(nickname);

            new Game(server, player);

            State.preGameScreen(server);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    private static void createGame() {

        String nickname = State.getNickname();
        int amountOfPlayers = State.getAmountOfPlayers();

        MonsterServer.start(amountOfPlayers);

        try {
            MonsterServerInterface server = (MonsterServerInterface) LocateRegistry.getRegistry(3000).lookup("server");

            server.initialise(new MonsterGameHandler());
            Player player = server.newPlayer(nickname);

            new Game(server, player);

            State.preGameScreen(server);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

    }

}
