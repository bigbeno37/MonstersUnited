package io.github.monstersunited.monstergame.tests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestBoard.class,
        TestClient.class,
        TestMonster.class,
        TestPlayer.class,
        //TestServer.class
})

public class TestAll {
}
