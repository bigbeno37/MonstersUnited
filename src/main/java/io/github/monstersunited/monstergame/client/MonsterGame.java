package io.github.monstersunited.monstergame.client;

import com.sun.security.ntlm.Client;
import io.github.monstersunited.monstergame.objects.Request;
import io.github.monstersunited.monstergame.objects.User;
import io.github.monstersunited.monstergame.server.MonsterServer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static io.github.monstersunited.monstergame.objects.RequestType.NEW_USER;

class MonsterGame implements Runnable{
    public static void main(String[] args) {
        System.out.println("Client started!");

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

        Socket client;

        // TODO
        // When user hits 'connect'...
        try {
            client = new Socket(serverAddress, port);

            // User is connected
            String username = State.getNickname();

            // Send username to server
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            out.writeObject(new Request(NEW_USER, new User(username)));

            State.preGameScreen(client);
        } catch (IOException e) {
            // TODO
            // Display error to user
            // Go back to connect screen
            System.out.println("Unable to connect. Confirm IP address is correct");
        }
    }

    private static void createGame() {

        String nickname = State.getNickname();
        int amountOfPlayers = State.getAmountOfPlayers();

        MonsterServer.start(nickname, amountOfPlayers);

        try {
            Socket client = new Socket("localhost", 3000);

            State.preGameScreen(client);
        } catch (IOException e) {
            System.out.println("Unable to connect to local server! This is probably bad");
        }

    }

    @Override
    public void run() {

    }
}
