package com.sportradar.scoreboard;


import java.util.*;

public class ScoreBoard {
    private static ScoreBoard instance;
    private final List<Game> games;


    public List<Game> getGames() {
        return games;
    }

    private ScoreBoard() {
        this.games = new LinkedList<>();
    }

    public static ScoreBoard getInstance() {//Singleton implementation
        if (instance == null) {
            instance = new ScoreBoard();
        }
        return instance;
    }
    public Game returnGame(String homeTeamName, String awayTeamName,boolean current) {
        for (Game game : games) {
            if (game.getHomeTeam().getName().equals(homeTeamName) &&
                    game.getAwayTeam().getName().equals(awayTeamName)&&((!game.isFinished()&&current)||(game.isFinished()&&!current))) {
                return game;
            }
        }
        return null;
    }

    public void startGame(String homeTeamName, String awayTeamName) {
        Game curerntGame=returnGame(homeTeamName,awayTeamName,true);
        if(curerntGame==null){
        Game game = GameFactory.createGame(homeTeamName, awayTeamName);
        games.add(game);
        }
    }



    public void finishGame(String homeTeamName, String awayTeamName) {
        for (Game game : games) {
            if (game.getHomeTeam().getName().equals(homeTeamName) &&
                    game.getAwayTeam().getName().equals(awayTeamName)&&!game.isFinished()) {
                game.finishGame(true);
                break;
            }
        }
    }

}
