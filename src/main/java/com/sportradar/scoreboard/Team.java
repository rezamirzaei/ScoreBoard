package com.sportradar.scoreboard;

public class Team {
    private final String name;

    private int score;

    private int liveScore; //to be used in live ranking

    private int goals;

    private int awayGoals;

    private int liveGoals; //to be used in live ranking

    private int liveAwayGoals; //to be used in live ranking



    public Team(String name) {
        this.name = name;
        this.score = 0;
        this.liveScore = 0;
        this.goals = 0;
        this.liveGoals = 0;
        this.awayGoals = 0;
        this.liveAwayGoals = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        setLiveScore(score);
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
        setLiveGoals(goals);
    }

    public int getLiveGoals() {
        return liveGoals;
    }

    public void setLiveGoals(int liveGoals) {
        this.liveGoals = liveGoals;
    }

    public void setAwayGoals(int goalsAway) {
        this.awayGoals = goalsAway;
        setLiveAwayGoals(goalsAway);
    }
    public int getAwayGoals() {
        return awayGoals;
    }

    public void setLiveAwayGoals(int liveGoalsAway) {
        this.liveAwayGoals = liveGoalsAway;
    }

    public int getLiveAwayGoals() {
        return liveAwayGoals;
    }

    public void addGoals(int goals) {
        this.liveGoals =this.goals+ goals;
        this.goals += goals;
    }

    public void addAwayGoals(int goals) {
        this.liveAwayGoals =this.awayGoals+ goals;
        this.awayGoals += awayGoals;
    }

    public void addScore(int score) {
        this.liveScore =this.score+ score;
        this.score += score;
    }

    public void addLiveGoals(int goals) {//to be used in update ranking
        this.liveGoals =this.goals+ goals;
    }

    public void addLiveAwayGoals(int goals) {//to be used in update ranking
        this.liveAwayGoals =this.awayGoals+ goals;
    }

    public void addLiveScore(int score) {//to be used in update ranking
        this.liveScore =this.score+ score;
    }

    public String toString() { //to show team, its live score and live goals
        return this.getName() + " " + this.getLiveScore()+ " " + this.getLiveGoals() ;
    }

}