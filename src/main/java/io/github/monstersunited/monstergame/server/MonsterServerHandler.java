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

    // Add callback functionality to the server
    @Override
    public void addClient(MonsterGameInterface client) throws RemoteException {
        MonsterServer.clients.add(client);
    }

    // Add a new player to the lobby if the lobby is not full
    // otherwise returning an exception
    @Override
    public Player addPlayer(String nickname) throws RemoteException, ServerFullException {

        if (MonsterServer.players.size() + 1 > MonsterServer.amountOfPlayers) {
            throw new ServerFullException();
        }

        Player player = new Player(nickname, 0, 0);

        MonsterServer.players.add(player);

        // Once the player has been added, refresh the player lists
        // on all connected clients
        for (MonsterGameInterface client: MonsterServer.clients) {
            client.refreshPlayerList(MonsterServer.players);
        }

        // If this was the last necessary client to connect,
        // start the game
        if (MonsterServer.players.size() == MonsterServer.amountOfPlayers) {
            MonsterServer.beginGame();
        }

        return player;
    }

    // Returns the server held list of all players
    @Override
    public List<Player> getAllPlayers() throws RemoteException {
        return MonsterServer.players;
    }

    // If the user enters an input during the game loop, determine which
    // player sent it and process that input to form a new position
    // if possible
    @Override
    public void sendInput(KeyEvent event, Player currentPlayer) throws RemoteException {
        for (Player player: MonsterServer.players) {
            if (player == currentPlayer) {
                player.processMove(event, MonsterServer.board);
            }
        }
    }
}
