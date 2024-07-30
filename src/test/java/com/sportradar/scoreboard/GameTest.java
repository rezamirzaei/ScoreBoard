package com.sportradar.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void GameCreationTest() {

        Team norway= new Team("Norway");
        Team usa= new Team("USA");
        Game game = new Game(norway,usa);

        assertEquals("Norway 0 - USA 0", game.toString());
    }

    @Test
    public void goalTest() {

        Team norway= new Team("Norway");
        Team usa= new Team("USA");

        Game game = new Game(norway,usa);
        game.setHomeGoals(5);
        game.setAwayGoals(2);


        assertEquals("Norway 5 - USA 2", game.toString());
    }
}
