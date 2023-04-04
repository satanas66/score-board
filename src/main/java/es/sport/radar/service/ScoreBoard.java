package es.sport.radar.service;

import java.util.List;

/**
 * @author EDWIN PATRICIO ARÉVALO ANGULO
 */
public interface ScoreBoard {

    /**
     * Function that starts a game given two team names.
     * @param teamName1, Home team name
     * @param teamName2, Away Team name
     */
    void startGame(String teamName1, String teamName2);

    /**
     * Function that ends a game given a game identifier.
     * @param idGame, Game id
     */
    void finishGame(String idGame);

    /**
     * Function that updates a game given a game identifier and the score of each team.
     * @param idGame, Game id
     * @param homeTeamScore, Home team score
     * @param awayTeamScore, Away team score
     */
    void updateScore(String idGame, Integer homeTeamScore, Integer awayTeamScore);

    /**
     * Function that returns a list with the summary of completed and updated games. In first positions the tie results will appear.
     * @return list resumen
     */
    List<String> summaryGames();

}
