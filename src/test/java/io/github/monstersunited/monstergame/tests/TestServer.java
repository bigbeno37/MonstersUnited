package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.interfaces.MonsterGameInterface;
import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.objects.exceptions.ServerFullException;
import io.github.monstersunited.monstergame.server.MonsterServer;
import io.github.monstersunited.monstergame.server.MonsterServerHandler;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.rmi.RemoteException;

import static io.github.monstersunited.monstergame.objects.enums.EntityState.DEAD;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestServer {

    MonsterServerHandler server;

    @BeforeClass
    public static void setUpServer() {
        MonsterServer.start(4);
    }

    @Before
    public void setUp() throws RemoteException {
        MonsterServer.reset();
        server = new MonsterServerHandler();
    }

    @Test
    public void addUserCorrectlyAddsUser() throws RemoteException, ServerFullException {
        server.addPlayer("nick");

        assertEquals("nick", server.getAllPlayers().get(0).getName());
    }

    @Test(expected = ServerFullException.class)
    public void newUserWillThrowExceptionIfTooManyPlayers() throws ServerFullException, RemoteException {
        server.addPlayer("nick");
        server.addPlayer("nick");
        server.addPlayer("nick");
        server.addPlayer("nick");
        server.addPlayer("nick");
    }

    @Test
    public void addPlayerCorrectlySetsID() {
        try {
            Player playerOne = server.addPlayer("Hello");
            Player playerTwo = server.addPlayer("World!");

            assertEquals(MonsterServer.board.getAmountOfPlayers(), 2);
            assertEquals(playerOne.getID(), 1);
            assertEquals(playerTwo.getID(), 2);
        } catch (RemoteException | ServerFullException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void gameStartsAfterPlayersHaveConnected() {
        MonsterGameInterface client = mock(MonsterGameInterface.class);
        try {
            server.addClient(client);

            server.addPlayer("Nick1");
            server.addPlayer("Nick1");
            server.addPlayer("Nick1");
            server.addPlayer("Nick1");

            verify(client).beginGame(any());
        } catch (RemoteException | ServerFullException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void gameFinishesAfterPlayersAreEaten() {
        MonsterGameInterface client = mock(MonsterGameInterface.class);

        try {
            server.addClient(client);

            Player one = server.addPlayer("Nick1");
            Player two = server.addPlayer("Nick1");
            Player three = server.addPlayer("Nick1");
            server.addPlayer("Nick1");

            one.setState(DEAD);
            two.setState(DEAD);
            three.setState(DEAD);

            verify(client, atLeastOnce()).endGame();

        } catch (RemoteException | ServerFullException e) {
            e.printStackTrace();
        }
    }
}
