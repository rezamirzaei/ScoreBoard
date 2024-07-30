package com.sportradar.scoreboard;

import java.time.LocalDateTime;

public interface Game{
     Team getHomeTeam();

     Team getAwayTeam();

     int getHomeGoals();

     void setHomeGoals(int homeGoals);

     int getAwayGoals();

     void setAwayGoals(int awayGoals);

     LocalDateTime getStartTime();

     LocalDateTime getEndTime();

     void setEndTime(LocalDateTime endTime);

     boolean isFinished();

     void setFinished(boolean finished);

     void addAwayGoals(int addAwayGoals);

     void addHomeGoals(int addHomeGoals);
     String getWinner();
     void finishGame(boolean force);
}
