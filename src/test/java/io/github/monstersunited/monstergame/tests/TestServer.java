package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.exceptions.ServerFullException;
import io.github.monstersunited.monstergame.server.MonsterServer;
import io.github.monstersunited.monstergame.server.MonsterServerHandler;
import org.junit.Before;
import org.junit.Test;

import java.rmi.RemoteException;

import static junit.framework.TestCase.assertEquals;

public class TestServer {

    MonsterServerHandler server;

    @Before
    public void setUp() throws RemoteException {
        MonsterServer.start(4);
        server = new MonsterServerHandler();
    }

    @Test
    public void addUserCorrectlyAddsUser() throws RemoteException, ServerFullException {
        server.newPlayer("nick");

        assertEquals("nick", server.getAllPlayers().get(0).getName());
    }

    @Test(expected = ServerFullException.class)
    public void newUserWillThrowExceptionIfTooManyPlayers() throws ServerFullException, RemoteException {
        server.newPlayer("nick");
        server.newPlayer("nick");
        server.newPlayer("nick");
        server.newPlayer("nick");
        server.newPlayer("nick");
    }


}
