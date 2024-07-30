package com.sportradar.scoreboard;

import java.time.LocalDateTime;


public class Game {

    private final Team homeTeam;
    private final Team awayTeam;
    private int homeGoals;
    private int awayGoals;
    private final LocalDateTime startTime;// in order to be used in match sorting
    private LocalDateTime endTime;
    private boolean isFinished;

    public Game(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.startTime = LocalDateTime.now();
        this.isFinished = false;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    @Override
    public String toString() {
        return homeTeam.getName() + " " + homeGoals + " - " + awayTeam.getName() + " " + awayGoals;
    }
}