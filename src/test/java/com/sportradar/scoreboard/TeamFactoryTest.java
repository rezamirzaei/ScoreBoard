package com.sportradar.scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeamFactoryTest {
    @Test
    public void CreateTeamTest() {
        Team team =TeamFactory.getOrCreateTeam("Norway");
        String summary=team.toString();
        String[] parts = summary.split(" ");
        String name = parts[0];
        assertEquals("Norway", name);
    }
}
