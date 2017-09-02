package io.github.monstersunited.monstergame.client;

import io.github.monstersunited.monstergame.interfaces.MonsterServerInterface;
import io.github.monstersunited.monstergame.objects.Player;

import java.rmi.RemoteException;
import java.util.List;

class State {
    // Switch scene to one that features a field for text input
    // and a submit button
    public static String getNickname() {
        // TODO
        // Display input field for user to input nickname
        return "macron";
    }

    // Display a log of server messages and currently connected players
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

    // Display an input field for user to input amount of players desired
    // between 2 and 4
    public static int getAmountOfPlayers() {
        // TODO
        // Get input
        return 4;
    }

    // Display a field to input a server address in the form
    // xxx.xxx.xxx.xxx:pppp
    // where x is a number, and p is a port number
    //
    // Returns the address in the first position of the array,
    // and the port in the second position
    public static String[] enterServerAddress() {
        // TODO
        // Actually get input
        return new String[] {"localhost", "3000"};
    }

    // Display two buttons to either create a new game lobby
    // or join one. True represents if the user creates a new
    // lobby, and false denotes joining a lobby
    public static boolean createOrJoinGame() {
        // TODO
        // Actually get input
        return true;
    }
}
