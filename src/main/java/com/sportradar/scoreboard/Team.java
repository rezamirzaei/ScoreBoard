package com.sportradar.scoreboard;

public class Team {
    private final String name;
    private int score;


    private int liveScore;
    private int goals;

    private int liveGoals;
    private int liveGoalsAway;

    private int goalsAway;

    public Team(String name) {
        this.name = name;
        this.score = 0;
        this.liveScore = 0;
        this.goals = 0;
        this.liveGoals = 0;
        this.goalsAway = 0;
        this.liveGoalsAway = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLiveScore() {
        return liveScore;
    }

    public void setLiveScore(int liveScore) {
        this.liveScore = liveScore;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getLiveGoals() {
        return liveGoals;
    }

    public void setLiveGoals(int liveGoals) {
        this.liveGoals = liveGoals;
    }

    public int getLiveGoalsAway() {
        return liveGoalsAway;
    }

    public void setLiveGoalsAway(int liveGoalsAway) {
        this.liveGoalsAway = liveGoalsAway;
    }

    public int getGoalsAway() {
        return goalsAway;
    }

    public void setGoalsAway(int goalsAway) {
        this.goalsAway = goalsAway;
    }



}