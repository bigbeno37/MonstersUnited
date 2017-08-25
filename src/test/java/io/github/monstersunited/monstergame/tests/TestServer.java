package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.objects.exceptions.InvalidAmountOfPlayersException;
import io.github.monstersunited.monstergame.objects.exceptions.TooManyPlayersException;
import io.github.monstersunited.monstergame.server.MonsterServer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestServer {
    @Test(expected = InvalidAmountOfPlayersException.class)
    public void gameWillNotStartWithLessThanProvidedPlayers() throws TooManyPlayersException, InvalidAmountOfPlayersException {
        MonsterServer.start("nick", 3);

        List<Player> players = new ArrayList<>();
        players.add(new Player("Jeoffrey"));

        MonsterServer.addPlayers(players);
        MonsterServer.beginGame();
    }

    @Test(expected = TooManyPlayersException.class)
    public void gameWillNotStartWithMoreThanProvidedPlayers() throws TooManyPlayersException {
        MonsterServer.start("nick", 2);

        List<Player> players = new ArrayList<>();
        players.add(new Player("Jeoffrey"));
        players.add(new Player("Patrick"));
        players.add(new Player("Marge"));

        MonsterServer.addPlayers(players);
    }

    @Test
    public void addPlayersCorrectlyUpdatesPlayerCount() throws TooManyPlayersException {
        MonsterServer.start("nick", 2);

        List<Player> players = new ArrayList<>();
        players.add(new Player("Jeoffrey"));
        players.add(new Player("Patrick"));

        MonsterServer.addPlayers(players);

        assertEquals(MonsterServer.amountOfPlayers, players.size());
    }
}
