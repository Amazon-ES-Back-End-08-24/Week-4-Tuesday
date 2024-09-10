package org.ironhack.classes;

import java.util.HashMap;

public class ScoreManager {
    private HashMap<String, Integer> scoreboard = new HashMap<>();

    public void addPlayer(String playerName, int score) {
        if (scoreboard.containsKey(playerName)) {
            System.out.println(playerName + " already exists in the scoreboard.");
        } else {
            scoreboard.put(playerName, score);
            System.out.println("Added " + score + " points to " + playerName);
        }
    }


    public void updateScore(String playerName, int newScore) {
        boolean containsKey = scoreboard.containsKey(playerName);

        if (containsKey) {
            scoreboard.put(playerName, newScore);
            System.out.println("Updated " + playerName + "'s score to " + newScore + " points.");
        } else {
            System.out.println(playerName + " does not exist in the scoreboard.");
        }
    }

    public void checkScore(String playerName) {
        if (scoreboard.containsKey(playerName)) {
            System.out.println(playerName + " has " + scoreboard.get(playerName) + " points.");
        } else {
            System.out.println(playerName + " is not in the scoreboard.");
        }
    }

    public void printAllScores() {
        System.out.println("Array of hasMap keys " + scoreboard.keySet());
        System.out.println("Scoreboard:");
        for (String player : scoreboard.keySet()) {
            System.out.println(player + ": " + scoreboard.get(player) + " points.");
        }
    }
}