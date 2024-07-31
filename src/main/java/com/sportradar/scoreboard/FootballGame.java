package com.sportradar.scoreboard;

import java.time.LocalDateTime;


public class FootballGame implements Game{

    private final Team homeTeam;
    private final Team awayTeam;
    private int homeGoals;
    private int awayGoals;
    private final LocalDateTime startTime;// in order to be used in match sorting
    private LocalDateTime endTime;
    private boolean isFinished;

    public FootballGame(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeGoals = 0;
        this.awayGoals = 0;
        this.startTime = LocalDateTime.now();
        this.isFinished = false;
    }
    @Override
    public Team getHomeTeam() {
        return homeTeam;
    }
    @Override
    public Team getAwayTeam() {
        return awayTeam;
    }
    @Override
    public int getHomeGoals() {
        return homeGoals;
    }
    @Override
    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
        this.homeTeam.addLiveGoals(homeGoals);
        getWinner();//to update live score
    }
    @Override
    public int getAwayGoals() {
        return awayGoals;
    }
    @Override
    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
        this.awayTeam.addLiveGoals(awayGoals);
        getWinner();//to update live score
    }
    @Override
    public LocalDateTime getStartTime() {
        return startTime;
    }
    @Override
    public LocalDateTime getEndTime() {
        return endTime;
    }
    @Override
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    @Override
    public boolean isFinished() {
        return isFinished;
    }
    @Override
    public void setFinished(boolean finished) {
        isFinished = finished;
    }
    @Override
    public void addAwayGoals(int addAwayGoals) {
        this.awayGoals += addAwayGoals;
        this.awayTeam.addLiveGoals(awayGoals);
        this.awayTeam.addLiveGoalsAway(awayGoals);
        getWinner();//to update live score
    }

    @Override
    public void addHomeGoals(int addHomeGoals) {
        this.homeGoals += addHomeGoals;
        this.homeTeam.addLiveGoals(homeGoals);
        getWinner();//to update live score
    }

@Override
    public String getWinner() {
        if (homeGoals > awayGoals) {
            this.homeTeam.addLiveScore(3);//to update live score
            this.awayTeam.addLiveScore(0); //fix bug in score, it adds 0 score to the current final score and provide live score
            return homeTeam.getName();
        } else if (awayGoals > homeGoals) {
            this.awayTeam.addLiveScore(3);//to update live score
            this.homeTeam.addLiveScore(0);//fix bug in score, it adds 0 score to the current final score and provide live score
            return awayTeam.getName();
        } else {
            this.homeTeam.addLiveScore(1);//to update live score
            this.awayTeam.addLiveScore(1);//to update live score
            return "Draw";
        }
    }
    @Override
    public void finishGame(boolean force) {
        if (force&&!isFinished) {
            setFinished(true);
            this.setEndTime(LocalDateTime.now());
            String winner = getWinner();
            if (winner.equals("Draw")) {
                this.homeTeam.addScore(1);//to update final score
                this.awayTeam.addScore(1);//to update final score
            } else if (winner.equals(this.homeTeam.getName())){
                this.homeTeam.addScore(3);//to update final score
            }
            else{
                this.awayTeam.addScore(3);//to update final score
            }
            this.homeTeam.addGoals(getHomeGoals());
            this.awayTeam.addGoals(getAwayGoals());
            this.awayTeam.addAwayGoals(getAwayGoals());
        }
    }


    @Override
    public String toString() {
        return homeTeam.getName() + " " + homeGoals + " - " + awayTeam.getName() + " " + awayGoals;
    }
}