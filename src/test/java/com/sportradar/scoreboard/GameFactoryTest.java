package com.sportradar.scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class GameFactoryTest {
    @Test
    public void CreateTeamTest() {
        Game game= GameFactory.createGame("Norway","USA");
        assertEquals("Norway 0 - USA 0", game.toString());
    }
}
