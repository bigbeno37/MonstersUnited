package io.github.monstersunited.monstergame.client;

import io.github.monstersunited.monstergame.interfaces.MonsterServerInterface;
import io.github.monstersunited.monstergame.objects.Player;

import java.rmi.RemoteException;
import java.util.List;

class State {
    public static String getNickname() {
        // TODO
        // Display input field for user to input nickname
        return "macron";
    }

    public static void preGameScreen(MonsterServerInterface server) {
        List<Player> players;

        try {
            players = server.getAllPlayers();
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
