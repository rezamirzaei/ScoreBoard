package com.sportradar.scoreboard;

public class GameFactory {
    public static Game createGame(String homeTeamName, String awayTeamName) {
        Team homeTeam = TeamFactory.getOrCreateTeam(homeTeamName);
        Team awayTeam = TeamFactory.getOrCreateTeam(awayTeamName);
        return new FootballGame(homeTeam, awayTeam);
    }
}