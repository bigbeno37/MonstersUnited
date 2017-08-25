package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.client.gui.Game;
import org.junit.Test;

public class TestTick {
    @Test
    public void TESTTick() {
        Game test = new Game();
        assert (test.running == true);
    }
}
