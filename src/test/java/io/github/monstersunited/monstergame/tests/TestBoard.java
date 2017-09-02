package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.Board;
import io.github.monstersunited.monstergame.objects.Monster;
import io.github.monstersunited.monstergame.objects.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestBoard {
    @Test
    public void updateBoardCorrectlyUpdatesBoard() {
        Board board = new Board();

        List<Player> players = new ArrayList<>();
        players.add(new Player("nick", 2, 4));
        players.add(new Player("ncik2", 3, 6));

        Monster monster = new Monster(3, 4);

        board.update();

        // TODO
        // Make this an actual check instead of always being correct
        return;
    }
}
