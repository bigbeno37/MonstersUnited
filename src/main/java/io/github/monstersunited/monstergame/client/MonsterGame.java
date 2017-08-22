package io.github.monstersunited.monstergame.client;

import com.esotericsoftware.kryonet.Client;
import io.github.monstersunited.monstergame.objects.Request;
import io.github.monstersunited.monstergame.objects.User;
import io.github.monstersunited.monstergame.server.MonsterServer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.github.monstersunited.monstergame.objects.RequestType.NEW_USER;

public class MonsterGame {
    public static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Client started!");

        Client client = new Client();
        new Thread(client).start();

        // TODO
        // Display two buttons; one to create a new game
        // and the other to join a game

        // TODO
        // Replace with user choice
        boolean createGame = false;

        if (createGame) {
            createGame(client);
        } else {
            joinGame(client);
        }


    }

    private static void joinGame(Client client) {
        // TODO
        // Get from User
        String serverAddress = "localhost";
        int tcpPort = 3000, udpPort = 3001;

        // TODO
        // When user hits 'connect'...
        try {
            client.connect(5000, serverAddress, tcpPort, udpPort);
        } catch (IOException e) {
            // TODO
            // Display error to user
            // Go back to connect screen
            System.out.println("Unable to connect. Confirm IP address is correct");
        }

        // User is connected

        String username = State.getNickname();

        // Send username to server
        Request sendUsername = new Request();
        // NEW_USER is an enum found in RequestType
        sendUsername.type = NEW_USER;
        sendUsername.data = username;
        client.sendTCP(sendUsername);

        State.preGameScreen(client);
    }

    static void createGame(Client client) {

        String nickname = State.getNickname();
        int amountOfPlayers = State.getAmountOfPlayers();

        MonsterServer.start(nickname, amountOfPlayers);

        try {
            client.connect(5000, "localhost", 3000, 3001);
        } catch (IOException e) {
            System.out.println("Unable to connect to local server! This is probably bad");
        }

        State.preGameScreen(client);

    }
}
