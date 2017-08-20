package io.github.monstersunited.monstergame.client;

import com.esotericsoftware.kryonet.Client;
import io.github.monstersunited.monstergame.objects.Request;
import io.github.monstersunited.monstergame.objects.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.github.monstersunited.monstergame.objects.RequestType.GET_USERS;
import static io.github.monstersunited.monstergame.objects.RequestType.NEW_USER;

public class MonsterGame {
    public static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Client started!");

        Client client = new Client();
        new Thread(client).start();

        // TODO
        // Display window with two fields
        // One for nickname and other for IP

        // Get from User
        String serverAddress = "localhost";
        int tcpPort = 3000, udpPort = 3001;

        String username = "macron";

        // TODO
        // When user hits 'connect'...
        try {
            client.connect(5000, serverAddress, tcpPort, udpPort);
        } catch (IOException e) {
            // Display error to user
            System.out.println("Unable to connect. Confirm IP address is correct");
        }

        // User is connected

        // Send username to server
        Request sendUsername = new Request();
        // NEW_USER is an enum found in RequestType
        sendUsername.type = NEW_USER;
        sendUsername.data = username;
        client.sendTCP(sendUsername);

        // Send a request to server to get all users
        Request request = new Request();
        // GET_USERS is an enum found in RequestType
        request.type = GET_USERS;
        client.sendTCP(request);

        // Listen for response from server
        client.addListener(new ClientListener());

        // TODO
        // Update the view and display users in a side panel
    }
}
