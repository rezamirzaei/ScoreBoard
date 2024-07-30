package com.sportradar.scoreboard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {
    @Test
    public void TeamCreation() {
        Team team= new Team("Norway");

        assertEquals("Norway", team.getName());
    }

    @Test
    public void TeamSummary() {
        Team team= new Team("Norway");

        assertEquals("Norway 0 0", team.toString());
    }

    @Test
    public void TeamAddGoals() {
        Team team= new Team("Norway");
        team.addGoals(1);
        String summary=team.toString();
        String[] parts = summary.split(" ");
        String LiveGoals = parts[2];
        assertEquals("1", LiveGoals);
    }
    @Test
    public void TeamAddScore() {
        Team team= new Team("Norway");
        team.addScore(3);
        String summary=team.toString();
        String[] parts = summary.split(" ");
        String LiveScore = parts[1];
        assertEquals("3", LiveScore);
    }

}
