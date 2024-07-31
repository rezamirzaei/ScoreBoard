package com.sportradar.scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreBoardTest {
    @Test
    public void SingletonScoreBoardTest() {

        ScoreBoard scoreBoard1 = ScoreBoard.getInstance();
        ScoreBoard scoreBoard2 = ScoreBoard.getInstance();

        assertEquals(scoreBoard1, scoreBoard2);
    }
}
