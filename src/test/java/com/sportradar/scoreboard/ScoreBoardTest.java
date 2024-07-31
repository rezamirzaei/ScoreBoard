package com.sportradar.scoreboard;

import org.junit.jupiter.api.Test;

import java.util.List;

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

        assertFalse(game.isFinished());

        scoreBoard.finishGame("Norway","USA");
        assertTrue(game.isFinished());
    }

    @Test
    public void updateGoalsTest() {
        ScoreBoard scoreBoard = ScoreBoard.getInstance();
        scoreBoard.startGame("Norway","USA");
        Game game=scoreBoard.returnGame("Norway","USA",true);
        assertEquals("Norway 0 - USA 0",game.toString());
        scoreBoard.updateGoals("Norway",3,"USA",0);
        assertEquals("Norway 3 - USA 0",game.toString());
        scoreBoard.finishGame("Norway","USA");
    }

    @Test
    public void addGoalsTest() {
        ScoreBoard scoreBoard = ScoreBoard.getInstance();
        scoreBoard.startGame("Norway","USA");
        Game game=scoreBoard.returnGame("Norway","USA",true);
        assertEquals("Norway 0 - USA 0",game.toString());
        scoreBoard.addGoals("Norway",3,"USA",0);
        assertEquals("Norway 3 - USA 0",game.toString());
        scoreBoard.addGoals("Norway",2,"USA",1);
        assertEquals("Norway 5 - USA 1",game.toString());
        scoreBoard.finishGame("Norway","USA");
    }

    @Test
    public void summaryTest() {
        ScoreBoard scoreBoard = ScoreBoard.getInstance();
        scoreBoard.startGame("Mexico","Canada");
        scoreBoard.updateGoals("Mexico",0,"Canada",5);

        scoreBoard.startGame("Spain","Brazil");
        scoreBoard.updateGoals("Spain",10,"Brazil",2);

        scoreBoard.startGame("Germany","France");
        scoreBoard.updateGoals("Germany",2,"France",2);

        scoreBoard.startGame("Uruguay","Italy");
        scoreBoard.updateGoals("Uruguay",6,"Italy",6);

        scoreBoard.startGame("Argentina","Australia");
        scoreBoard.updateGoals("Argentina",3,"Australia",1);

        List<String> summaryList= scoreBoard.gamesSummary();

        assertEquals("Uruguay 6 - Italy 6",summaryList.get(0));
        assertEquals("Spain 10 - Brazil 2",summaryList.get(1));
        assertEquals("Mexico 0 - Canada 5",summaryList.get(2));
        assertEquals("Argentina 3 - Australia 1",summaryList.get(3));
        assertEquals("Germany 2 - France 2",summaryList.get(4));
    }



}
