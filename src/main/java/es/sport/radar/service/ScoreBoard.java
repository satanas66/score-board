package es.sport.radar.service;

import java.util.List;

public interface ScoreBoard {

    void startGame(String teamName1, String teamName2);

    void finishGame(String idGame);

    void updateScore(String idGame, Integer homeTeamScore, Integer awayTeamScore);

    List<String> summaryGames();

}
