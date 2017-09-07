package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.exceptions.ServerFullException;
import io.github.monstersunited.monstergame.server.MonsterServer;
import io.github.monstersunited.monstergame.server.MonsterServerHandler;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.rmi.RemoteException;

import static junit.framework.TestCase.assertEquals;

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
            server.addPlayer("Hello");
            server.addPlayer("World!");

            assertEquals(MonsterServer.board.getAmountOfPlayers(), 2);
            assertEquals(MonsterServer.board.getPlayers().get(0).getID(), 1);
            assertEquals(MonsterServer.board.getPlayers().get(1).getID(), 2);
        } catch (RemoteException | ServerFullException e) {
            e.printStackTrace();
        }
    }
}
