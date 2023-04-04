package es.sport.radar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ScoreBoardImplTest {

    private static String idGame;

    private static String nameHometeam;

    private static String nameAwayTeam;

    private static ScoreBoardImpl scoreBoard;

    @BeforeEach
    void setUpEach() {
        idGame = "ECUA_ALEM";
        nameHometeam = "ECUADOR";
        nameAwayTeam = "ALEMANIA";
        scoreBoard = new ScoreBoardImpl();
    }

    @Test
    void testStartGame() {
        scoreBoard.startGame(nameHometeam, nameAwayTeam);
        assertThat(scoreBoard.getInitialScoreBoard().size()).isEqualTo(1);
    }

    @Test
    void testStartGameSameTeams() {
        scoreBoard.startGame(nameHometeam, nameAwayTeam);
        scoreBoard.startGame(nameHometeam, nameAwayTeam);
        assertThat(scoreBoard.getInitialScoreBoard().size() == 2).isFalse();
    }

    @Test
    void testStartGameNoValid() {
        scoreBoard.startGame(null, nameAwayTeam);
        assertThat(scoreBoard.getInitialScoreBoard().size()).isEqualTo(0);

        scoreBoard.startGame(nameHometeam, null);
        assertThat(scoreBoard.getInitialScoreBoard().size()).isEqualTo(0);

        scoreBoard.startGame("", nameAwayTeam);
        assertThat(scoreBoard.getInitialScoreBoard().size()).isEqualTo(0);

        scoreBoard.startGame(nameHometeam, "");
        assertThat(scoreBoard.getInitialScoreBoard().size()).isEqualTo(0);
    }

    @Test
    void finishGame() {
        scoreBoard.startGame(nameHometeam, nameAwayTeam);
        assertThat(scoreBoard.getInitialScoreBoard().size()).isEqualTo(1);
    }

    @Test
    void finishGameNoValid() {
        scoreBoard.startGame(nameHometeam, nameAwayTeam);

        scoreBoard.finishGame("");
        assertThat(scoreBoard.getInitialScoreBoard().size()).isEqualTo(1);

        scoreBoard.finishGame(null);
        assertThat(scoreBoard.getInitialScoreBoard().size()).isEqualTo(1);

        scoreBoard.finishGame("NADA");
        assertThat(scoreBoard.getInitialScoreBoard().size()).isEqualTo(1);
    }

    @Test
    void testUpdateScoreNoGameOver() {
        scoreBoard.startGame(nameHometeam, nameAwayTeam);
        scoreBoard.updateScore(idGame, 4, 1);
        assertThat(scoreBoard.getInitialScoreBoard().size() == 1).isTrue();
    }

    @Test
    void testUpdateScoreWithGameOver() {
        scoreBoard.startGame(nameHometeam, nameAwayTeam);
        scoreBoard.finishGame(idGame);
        scoreBoard.updateScore(idGame, 4, 4);
        assertThat(scoreBoard.getInitialScoreBoard().size() == 0).isTrue();
        assertThat(scoreBoard.getFinalScoreBoard().size() == 1).isTrue();

    }

    @Test
    void testUpdateScoreNoValid() {
        scoreBoard.startGame(nameHometeam, nameAwayTeam);

        scoreBoard.updateScore(null, 1, 1);
        assertThat(scoreBoard.getInitialScoreBoard().get(idGame).getHomeTeam().getScore() == 0).isTrue();

        scoreBoard.updateScore(idGame, -1, 1);
        assertThat(scoreBoard.getInitialScoreBoard().get(idGame).getHomeTeam().getScore() == 0).isTrue();

        scoreBoard.updateScore(idGame, null, 1);
        assertThat(scoreBoard.getInitialScoreBoard().get(idGame).getHomeTeam().getScore() == 0).isTrue();

        scoreBoard.updateScore(idGame, 1, -1);
        assertThat(scoreBoard.getInitialScoreBoard().get(idGame).getHomeTeam().getScore() == 0).isTrue();

        scoreBoard.updateScore(idGame, 0, null);
        assertThat(scoreBoard.getInitialScoreBoard().get(idGame).getHomeTeam().getScore() == 0).isTrue();
    }
}
