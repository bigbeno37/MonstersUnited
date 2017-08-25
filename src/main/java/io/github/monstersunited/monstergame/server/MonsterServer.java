package io.github.monstersunited.monstergame.server;

import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.objects.exceptions.InvalidAmountOfPlayersException;
import io.github.monstersunited.monstergame.objects.exceptions.TooManyPlayersException;

import java.util.ArrayList;
import java.util.List;

public class MonsterServer {

    public static int amountOfPlayers = 0;
    static List<Player> players;

    public static void initialiseGame(String nickname, int players) {
        // TODO
        // Start the server and add the first player
        amountOfPlayers = players;
        MonsterServer.players = new ArrayList<>();
    }

    public static void addPlayers(List<Player> players) throws TooManyPlayersException {

        if (players.size() > amountOfPlayers) {
            throw new TooManyPlayersException();
        }

        MonsterServer.players.addAll(players);
    }


    public static void beginGame() throws InvalidAmountOfPlayersException {
        if (MonsterServer.players.size() != amountOfPlayers) {
            throw new InvalidAmountOfPlayersException();
        }
    }
}
