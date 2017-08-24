package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.Box.Box;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestBlock {
    @Test
    public void getBoxType() {
        Box test = new Box();
        String result = test.NAME("FIN","ISHED");
        assertEquals("FINISHED",result);
    }
    @Test
    public void TESTDeathAnimation() {
        Box testDeath = new Box();
        int result = testDeath.DeathAnimation(0);
        assertEquals(1,result);
    }
    @Test
    public void TESTPlaceBoxes() {
        Box testPlace = new Box();
        int result = testPlace.PlaceBoxes(60);
        assertEquals(0,result);
    }
    @Test
    public void TESTBoxRecharge() {
        Box testReCharge = new Box();
        boolean result = testReCharge.BoxRecharge(false);
        assertEquals(false,result);
    }


}
