package com.sportradar.scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FootballGameTest {
    @Test
    public void FootballGameCreationTest() {

        Team norway= new Team("Norway");
        Team usa= new Team("USA");
        Game game = new FootballGame(norway,usa);

        assertEquals("Norway 0 - USA 0", game.toString());
    }

    @Test
    public void goalTest() {

        Team norway= new Team("Norway");
        Team usa= new Team("USA");

        Game game = new FootballGame(norway,usa);
        game.setHomeGoals(5);
        game.setAwayGoals(2);


        assertEquals("Norway 5 - USA 2", game.toString());
    }

    @Test
    public void liveGoalTest() {

        Team norway= new Team("Norway");
        Team usa= new Team("USA");

        Game gameNorwayUSA = new FootballGame(norway,usa);
        gameNorwayUSA.setHomeGoals(5);
        gameNorwayUSA.setAwayGoals(2);

        String summaryNorway=norway.toString();
        String[] partsSummaryNorway = summaryNorway.split(" ");
        String LiveGoalsNorway = partsSummaryNorway[2];
        assertEquals("5", LiveGoalsNorway);

        String summaryUSA=usa.toString();
        String[] partsSummaryUSA = summaryUSA.split(" ");
        String LiveGoalsUSA = partsSummaryUSA[2];
        assertEquals("2", LiveGoalsUSA);
        gameNorwayUSA.finishGame(true);

        Team sweden= new Team("Sweden");
        Game gameSwedenUSA = new FootballGame(sweden,usa);
        gameSwedenUSA.setHomeGoals(3);
        gameSwedenUSA.setAwayGoals(1);

        String summarySweden=sweden.toString();
        String[] partsSummarySweden = summarySweden.split(" ");
        String LiveGoalsSweden = partsSummarySweden[2];
        assertEquals("3", LiveGoalsSweden);

        summaryUSA = usa.toString();
        partsSummaryUSA = summaryUSA.split(" ");
        LiveGoalsUSA = partsSummaryUSA[2];
        assertEquals("3", LiveGoalsUSA);
    }
@Test
    public void scoreTest() {

        Team norway= new Team("Norway");
        Team usa= new Team("USA");

        Game gameNorwayUSA = new FootballGame(norway,usa);
        gameNorwayUSA.setHomeGoals(2);
        gameNorwayUSA.setAwayGoals(5);

        String summaryNorway=norway.toString();
        String[] partsSummaryNorway = summaryNorway.split(" ");
        String LiveScoreNorway = partsSummaryNorway[1];
        assertEquals("0", LiveScoreNorway);

        String summaryUSA=usa.toString();
        String[] partsSummaryUSA = summaryUSA.split(" ");
        String LiveScoreUSA = partsSummaryUSA[1];
        assertEquals("3", LiveScoreUSA);
        gameNorwayUSA.addHomeGoals(4);
        gameNorwayUSA.finishGame(true);

        summaryUSA=usa.toString();
        partsSummaryUSA = summaryUSA.split(" ");
        LiveScoreUSA = partsSummaryUSA[1];
        assertEquals("0", LiveScoreUSA);

         summaryNorway=norway.toString();
         partsSummaryNorway = summaryNorway.split(" ");
         LiveScoreNorway = partsSummaryNorway[1];
        assertEquals("3", LiveScoreNorway);

    }
}
