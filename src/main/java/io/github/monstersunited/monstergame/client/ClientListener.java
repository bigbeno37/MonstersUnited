package io.github.monstersunited.monstergame.client;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import io.github.monstersunited.monstergame.objects.Users;

public class ClientListener extends Listener {
    @Override
    public void received(Connection connection, Object object) {
        if (object instanceof Users) {
            MonsterGame.users = ((Users) object).users;
        }
    }
}
