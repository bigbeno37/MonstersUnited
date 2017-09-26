package io.github.monstersunited.monstergame.server;

import io.github.monstersunited.monstergame.interfaces.MonsterGameInterface;
import io.github.monstersunited.monstergame.objects.Player;

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

        if (!MonsterServer.isThereOnlyOnePlayerLeft()) {

            removeBoxIfTimerExpired();

            MonsterServer.board.getMonster().moveTowardsClosestPlayer(MonsterServer.board);
            MonsterServer.board.update();

            updateClients();
        } else {
            MonsterServer.lobbyRunning = false;

            this.cancel();
        }
    }

    private void removeBoxIfTimerExpired() {
        for (Player player: MonsterServer.board.getPlayers()) {
            if (player.getBox() != null) {

                if (player.getBox().reduceTimer() == 0) {
                    player.removeBox();
                }

            }
        }
    }

    private void updateClients() {
        for (MonsterGameInterface client: MonsterServer.clients) {
            try {
                client.update(MonsterServer.board);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}