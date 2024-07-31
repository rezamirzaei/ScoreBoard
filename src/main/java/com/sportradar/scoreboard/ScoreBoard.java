package com.sportradar.scoreboard;

import java.util.*;

public class ScoreBoard {
    private static ScoreBoard instance;
    private List<Game> games;


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

}
