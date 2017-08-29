package io.github.monstersunited.monstergame.client;

import io.github.monstersunited.monstergame.interfaces.MonsterServerInterface;
import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.objects.Request;
import io.github.monstersunited.monstergame.objects.User;
import io.github.monstersunited.monstergame.objects.Users;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static io.github.monstersunited.monstergame.objects.RequestType.GET_USERS;

class State {
    public static String getNickname() {
        // TODO
        // Display input field for user to input nickname
        return "macron";
    }

    public static void preGameScreen(MonsterServerInterface server) {
        List<Player> players;

        try {
            players = server.getAllUsers();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        // TODO
        // Update the view and display users in a side panel
    }

    public static int getAmountOfPlayers() {
        // TODO
        // Display input field for user to input amount of players desired
        // between 2 and 4
        return 4;
    }
}
