package io.github.monstersunited.monstergame.tests;

import io.github.monstersunited.monstergame.objects.Monster;
import org.junit.Test;

public class TestMonster {
    @Test
    public void TESTmonsterCanEatPlayer() {
    Monster monster = new Monster(1, 1);
    int result = monster.monsterCanEatPlayer(3);
    }
    @Test
    public void TESTmonsterGoesToNearestPlayer(){
        Monster monster = new Monster(1, 1);
        
    }
}
