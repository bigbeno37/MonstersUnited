package io.github.monstersunited.monstergame.server;

import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.objects.exceptions.InvalidAmountOfPlayersException;
import io.github.monstersunited.monstergame.objects.exceptions.TooManyPlayersException;

import java.util.ArrayList;
import java.util.List;

public class MonsterServer {

    public static int amountOfPlayers;
    static List<Player> players = new ArrayList<>();

    public static void start(String nickname, int players) {
        // TODO
        // Start the server and add the first player
        amountOfPlayers = players;
    }

    public static void addPlayers(List<Player> players) throws TooManyPlayersException {

        if (players.size() > amountOfPlayers) {
            throw new TooManyPlayersException();
        }
    }


    public static void beginGame() throws InvalidAmountOfPlayersException {
        if (players.size() != amountOfPlayers) {
            throw new InvalidAmountOfPlayersException();
        }
    }
}
