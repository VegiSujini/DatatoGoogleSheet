package com.example.fifaworldcup.dto;

public class MatchDetails {
    private String year;
    private String winner;
    private String score;
    private String runners;

    public MatchDetails(String year, String winner, String score, String runners) {
        this.year = year;
        this.winner = winner;
        this.score = score;
        this.runners = runners;
    }

    public String getYear() {
        return year;
    }

    public String getWinner() {
        return winner;
    }

    public String getScore() {
        return score;
    }

    public String getRunners() {
        return runners;
    }
}
