package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.server.MonsterServer;
import io.github.monstersunited.monstergame.server.MonsterServerHandler;
import org.junit.Test;

import java.rmi.RemoteException;

import static org.junit.Assert.assertEquals;

public class TestServer {

    @Test
    public void addUserCorrectlyAddsUser() throws RemoteException {
        MonsterServer.start(4);

        MonsterServerHandler server = new MonsterServerHandler();

        server.newPlayer("nick");

        assertEquals("nick", server.getAllPlayers().get(0).name);
    }
}
