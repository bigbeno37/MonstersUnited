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

        if (MonsterServer.board.getAmountOfPlayers() + 1 > MonsterServer.maxPlayers) {
            throw new ServerFullException();
        }

        // Set the id to the length of the amount of players plus 1
        // i.e. the first player has id 1 and not 0
        Player player = new Player(nickname, 0, 0, MonsterServer.board.getAmountOfPlayers()+1);

        MonsterServer.board.addBoardPiece(player);

        // Once the player has been added, refresh the player lists
        // on all connected clients
        for (MonsterGameInterface client: MonsterServer.clients) {
            client.refreshPlayerList(MonsterServer.board.getPlayers());
        }

        // If this was the last necessary client to connect,
        // start the game
        if (MonsterServer.board.getAmountOfPlayers() == MonsterServer.maxPlayers) {
            MonsterServer.beginGame();
        }

        return player;
    }

    // Returns the server held list of all players
    @Override
    public List<Player> getAllPlayers() throws RemoteException {
        return MonsterServer.board.getPlayers();
    }

    // If the user enters an input during the game loop, determine which
    // player sent it and process that input to form a new position
    // if possible
    @Override
    public void sendInput(KeyEvent event, Player currentPlayer) throws RemoteException {
        for (Player player: MonsterServer.board.getPlayers()) {
            if (player.getID() == currentPlayer.getID()) {
                player.processMove(event, MonsterServer.board);
            }
        }
    }

    @Override
    public boolean isRunning() throws RemoteException {
        return MonsterServer.isRunning;
    }

    @Override
    public boolean isLobbyRunning() throws RemoteException {
        return MonsterServer.lobbyRunning;
    }
}
