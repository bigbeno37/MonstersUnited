package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.interfaces.MonsterGameInterface;
import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.objects.exceptions.ServerFullException;
import io.github.monstersunited.monstergame.server.MonsterServer;
import io.github.monstersunited.monstergame.server.MonsterServerHandler;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.rmi.RemoteException;

import static io.github.monstersunited.monstergame.objects.enums.EntityState.DEAD;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.*;

public class TestServer {

    MonsterServerHandler server;

    @BeforeClass
    public static void setUpServer() {
        if (!MonsterServer.isRunning) {
            MonsterServer.start(4);
        }
    }

    @Before
    public void setUp() throws RemoteException {
        MonsterServer.reset();
        server = new MonsterServerHandler();
    }

    @Test
    public void addUserCorrectlyAddsUser() throws RemoteException, ServerFullException {
        assertEquals(0, server.getAllPlayers().size());

        server.addPlayer("nick", null);

        assertEquals(1, server.getAllPlayers().size());
        assertEquals("nick", server.getAllPlayers().get(0).getName());
    }

    @Test(expected = ServerFullException.class)
    public void newUserWillThrowExceptionIfTooManyPlayers() throws ServerFullException, RemoteException {
        server.addPlayer("nick", null);
        server.addPlayer("nick", null);
        server.addPlayer("nick",  null);
        server.addPlayer("nick", null);
        server.addPlayer("nick", null);
    }

    @Test
    public void addPlayerCorrectlySetsID() {
        try {
            assertEquals(0, server.getAllPlayers().size());

            Player playerOne = server.addPlayer("Hello", null);
            Player playerTwo = server.addPlayer("World!", null);

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

            assertFalse(server.isLobbyRunning());

            server.addPlayer("Nick1", client);
            assertFalse(server.isLobbyRunning());
            server.addPlayer("Nick1", client);
            assertFalse(server.isLobbyRunning());
            server.addPlayer("Nick1", client);
            assertFalse(server.isLobbyRunning());
            server.addPlayer("Nick1", client);

            assertTrue(server.isRunning());
            assertTrue(server.isLobbyRunning());

//            verify(client).beginGame(any());
        } catch (RemoteException | ServerFullException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void gameFinishesAfterPlayersAreEaten() {
        MonsterGameInterface client = mock(MonsterGameInterface.class);

        try {
            Player one = server.addPlayer("Nick1", client);
            Player two = server.addPlayer("Nick1", client);
            Player three = server.addPlayer("Nick1", client);
            server.addPlayer("Nick1", client);

            one.setState(DEAD);
            two.setState(DEAD);
            three.setState(DEAD);

//            verify(client, atLeastOnce()).endGame();

        } catch (RemoteException | ServerFullException e) {
            e.printStackTrace();
        }
    }
}
