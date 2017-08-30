package io.github.monstersunited.monstergame.tests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestBlock.class,
        TestBoard.class,
        TestClient.class,
        TestEntity.class,
        TestMonster.class,
        TestPlayer.class,
        TestServer.class
})

public class TestAll {
}
