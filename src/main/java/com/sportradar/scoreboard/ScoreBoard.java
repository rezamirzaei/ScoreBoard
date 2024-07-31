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

    public void updateGoals(String homeTeamName, int homeGoal, String awayTeamName, int awayGoal) {
        for (Game game : games) {
            if (game.getHomeTeam().getName().equals(homeTeamName) &&
                    game.getAwayTeam().getName().equals(awayTeamName) &&
                    !game.isFinished()) {
                game.setHomeGoals(homeGoal);
                game.setAwayGoals(awayGoal);
                break;
            }
        }
    }

    public void addGoals(String homeTeamName, int homeGoal, String awayTeamName, int awayGoal) {
        for (Game game : games) {
            if (game.getHomeTeam().getName().equals(homeTeamName) &&
                    game.getAwayTeam().getName().equals(awayTeamName) &&
                    !game.isFinished()) {
                game.addHomeGoals(homeGoal);
                game.addAwayGoals(awayGoal);
                break;
            }
        }
    }

    public List<Game> getSortedLiveGames() {
        List<Game> liveGames = new ArrayList<>();
        for (Game game : games) {
            if (!game.isFinished()) {
                liveGames.add(game);
            }
        }

        liveGames.sort(new Comparator<Game>() {
            @Override
            public int compare(Game game1, Game game2) {
                int totalGoalsComparison = Integer.compare(game2.getHomeGoals() + game2.getAwayGoals(), game1.getHomeGoals() + game1.getAwayGoals());
                if (totalGoalsComparison != 0) {
                    return totalGoalsComparison;
                } else {
                    return games.indexOf(game2) - games.indexOf(game1);
                }
            }
        });
        return liveGames;
    }

    public List<String> gamesSummary() {
        List<Game> liveGames = new ArrayList<>();
        for (Game game : games) {
            if (!game.isFinished()) {
                liveGames.add(game);
            }
        }

        liveGames.sort(new Comparator<Game>() {
            @Override
            public int compare(Game game1, Game game2) {
                int totalGoalsComparison = Integer.compare(game2.getHomeGoals() + game2.getAwayGoals(), game1.getHomeGoals() + game1.getAwayGoals());
                if (totalGoalsComparison != 0) {
                    return totalGoalsComparison;
                } else {
                    return games.indexOf(game2) - games.indexOf(game1);
                }
            }
        });

        List<String> liveReport = new ArrayList<>();//to protect games list
        for (Game game : liveGames) { //to protect games list
            liveReport.add(game.toString()); //to protect games list
        } //to protect games list

        return liveReport;
    }

}
