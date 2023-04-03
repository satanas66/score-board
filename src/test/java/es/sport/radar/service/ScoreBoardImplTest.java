package es.sport.radar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ScoreBoardImplTest {

    private static String nameHometeam;

    private static String nameAwayTeam;

    private static ScoreBoardImpl scoreBoard;

    @BeforeEach
    void setUpEach() {
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
}
