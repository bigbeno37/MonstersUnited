package io.github.monstersunited.monstergame.client;

import io.github.monstersunited.monstergame.objects.Request;
import io.github.monstersunited.monstergame.objects.User;
import io.github.monstersunited.monstergame.objects.Users;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static io.github.monstersunited.monstergame.objects.RequestType.GET_USERS;

class State {
    static String getNickname() {
        // TODO
        // Display input field for user to input nickname
        return "macron";
    }

    static void preGameScreen(Socket client) {
        List<User> users = new ArrayList<>();

        try {
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());

            Request request = new Request(GET_USERS, null);
            out.writeObject(request);

            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            users = ((Users) in.readObject()).users;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

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
