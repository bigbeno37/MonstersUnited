package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.Box;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestBlock {
    @Test
    public void reduceTimerCorrectlyReducesTimer() {
        Box box = new Box(10);
        assertEquals(box.reduceTimer(), 9);
    }

}
