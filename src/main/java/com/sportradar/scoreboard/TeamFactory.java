package com.sportradar.scoreboard;

import java.util.HashMap;
import java.util.Map;

public class TeamFactory {

    private static final Map<String, Team> teams = new HashMap<>();

    public static Team getOrCreateTeam(String name) {
        if (teams.containsKey(name)) {
            return teams.get(name);
        }
        teams.put(name, new Team(name));
        return teams.get(name);
    }

    public static boolean teamExists(String name) {
        return teams.containsKey(name);
    }

    public static Map<String, Team> getTeams() {
        return teams;
    }
}
