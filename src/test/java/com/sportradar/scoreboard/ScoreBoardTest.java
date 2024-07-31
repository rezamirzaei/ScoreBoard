package com.sportradar.scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreBoardTest {
    @Test
    public void singletonScoreBoardTest() {

        ScoreBoard scoreBoard1 = ScoreBoard.getInstance();
        ScoreBoard scoreBoard2 = ScoreBoard.getInstance();

        assertEquals(scoreBoard1, scoreBoard2);
    }

    @Test
    public void startGameTest() {
        ScoreBoard scoreBoard = ScoreBoard.getInstance();
        scoreBoard.startGame("Norway","USA");
        Game game=scoreBoard.returnGame("Norway","USA",true);

        assertEquals("Norway 0 - USA 0", game.toString());

        scoreBoard.finishGame("Norway","USA");
    }

    @Test
    public void finishGameTest() {
        ScoreBoard scoreBoard = ScoreBoard.getInstance();
        scoreBoard.startGame("Norway","USA");
        Game game=scoreBoard.returnGame("Norway","USA",true);

        assertEquals(false, game.isFinished());

        scoreBoard.finishGame("Norway","USA");
        assertEquals(true, game.isFinished());
    }

}
