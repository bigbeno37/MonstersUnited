package io.github.monstersunited.monstergame.server;

import io.github.monstersunited.monstergame.interfaces.MonsterGameInterface;

import java.rmi.RemoteException;
import java.util.TimerTask;

public class GameLoop extends TimerTask {

    public GameLoop() {
    }

    @Override
    public void run() {
        // Every loop, the monster should move towards the closest
        // player, and each player have their position updated
        // according to what direction they input
        MonsterServer.board.getMonster().moveTowardsClosestPlayer(MonsterServer.board);
        MonsterServer.board.update();

        // Check to see if there's only one player alive
        if(MonsterServer.checkEatenPlayers()) {
            this.cancel();
        }

        // Afterwards, send the new positions to the clients
        for (MonsterGameInterface client: MonsterServer.clients) {
            try {
                client.update(MonsterServer.board);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
