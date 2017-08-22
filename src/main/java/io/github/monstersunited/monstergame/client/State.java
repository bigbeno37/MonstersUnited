package io.github.monstersunited.monstergame.client;

import com.esotericsoftware.kryonet.Client;
import io.github.monstersunited.monstergame.objects.Request;

import static io.github.monstersunited.monstergame.objects.RequestType.GET_USERS;

class State {
    static String getNickname() {
        // TODO
        // Display input field for user to input nickname
        return "macron";
    }

    static void preGameScreen(Client client) {
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

    static int getAmountOfPlayers() {
        // TODO
        // Display input field for user to input amount of players desired
        // between 2 and 4
        return 4;
    }
}
