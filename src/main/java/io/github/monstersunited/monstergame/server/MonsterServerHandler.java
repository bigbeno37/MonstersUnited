package io.github.monstersunited.monstergame.server;

import io.github.monstersunited.monstergame.interfaces.MonsterGameInterface;
import io.github.monstersunited.monstergame.interfaces.MonsterServerInterface;
import io.github.monstersunited.monstergame.objects.Player;
import io.github.monstersunited.monstergame.objects.exceptions.ServerFullException;

import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MonsterServerHandler extends UnicastRemoteObject implements MonsterServerInterface {
    public MonsterServerHandler() throws RemoteException {
        super();
    }

    @Override
    public void initialise(MonsterGameInterface client) throws RemoteException {
        MonsterServer.clients.add(client);
    }

    @Override
    public Player newPlayer(String nickname) throws RemoteException, ServerFullException {

        if (MonsterServer.players.size() + 1 > MonsterServer.amountOfPlayers) {
            throw new ServerFullException();
        }

        Player player = new Player(nickname, 0, 0);

        MonsterServer.players.add(player);

        for (MonsterGameInterface client: MonsterServer.clients) {
            client.refreshPlayerList(MonsterServer.players);
        }

        if (MonsterServer.players.size() == MonsterServer.amountOfPlayers) {
            MonsterServer.beginGame();
        }

        return player;
    }

    @Override
    public List<Player> getAllPlayers() throws RemoteException {
        return MonsterServer.players;
    }

    @Override
    public void sendInput(KeyEvent event, Player currentPlayer) throws RemoteException {
        for (Player player: MonsterServer.players) {
            if (player == currentPlayer) {
                player.processMove(event, MonsterServer.board);
            }
        }
    }
}
