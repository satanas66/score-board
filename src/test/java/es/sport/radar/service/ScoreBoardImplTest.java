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
        assertThat(scoreBoard.getInitialScoreBoard().size() == 0 &&
                scoreBoard.getFinalScoreBoard().size() == 1).isTrue();

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

    @Test
    void testSummaryGamesEmpty() {
        assertThat(scoreBoard.summaryGames().size() == 0).isTrue();
    }

    @Test
    void testSummaryGames() {
        scoreBoard.startGame(nameHometeam, nameAwayTeam);
        scoreBoard.startGame("BOLIVIA", "BRAZIL");
        scoreBoard.startGame("COLOMBIA", "VENEZUELA");
        scoreBoard.startGame("ECUADOR", "BRAZIL");
        scoreBoard.startGame("MEXICO", "CANADA");
        scoreBoard.startGame("ESPAÑA", "BRAZIL");
        scoreBoard.startGame("ALEMANIA", "FRANCIA");
        scoreBoard.startGame("URUGUAY", "ITALIA");
        scoreBoard.startGame("ARGENTINA", "AUSTRALIA");

        scoreBoard.updateScore(idGame, 4, 4);
        scoreBoard.updateScore("BOLI_BRAZ", 0, 3);
        scoreBoard.updateScore("COLO_VENE", 1, 3);
        scoreBoard.updateScore("ECUA_BRAZ", 2, 2);
        scoreBoard.updateScore("MEXI_CANA", 0, 5);
        scoreBoard.updateScore("ESPA_BRAZ", 10, 2);
        scoreBoard.updateScore("ALEM_FRAN", 2, 2);
        scoreBoard.updateScore("URUG_ITAL", 6, 6);
        scoreBoard.updateScore("ARGE_AUST", 3, 1);

        scoreBoard.finishGame(idGame);
        scoreBoard.finishGame("COLO_VENE");
        scoreBoard.finishGame("ECUA_BRAZ");
        scoreBoard.finishGame("BOLI_BRAZ");
        scoreBoard.finishGame("MEXI_CANA");
        scoreBoard.finishGame("ESPA_BRAZ");
        scoreBoard.finishGame("ALEM_FRAN");
        scoreBoard.finishGame("URUG_ITAL");
        scoreBoard.finishGame("ARGE_AUST");

        assertThat(scoreBoard.summaryGames().get(0).equals("URUGUAY 6 - ITALIA 6") &&
                scoreBoard.summaryGames().get(1).equals("ALEMANIA 2 - FRANCIA 2") &&
                scoreBoard.summaryGames().get(2).equals("ECUADOR 2 - BRAZIL 2") &&
                scoreBoard.summaryGames().get(3).equals("ECUADOR 4 - ALEMANIA 4") &&
                scoreBoard.summaryGames().get(4).equals("COLOMBIA 1 - VENEZUELA 3") &&
                scoreBoard.summaryGames().get(5).equals("BOLIVIA 0 - BRAZIL 3") &&
                scoreBoard.summaryGames().get(6).equals("MEXICO 0 - CANADA 5") &&
                scoreBoard.summaryGames().get(7).equals("ESPAÑA 10 - BRAZIL 2") &&
                scoreBoard.summaryGames().get(8).equals("ARGENTINA 3 - AUSTRALIA 1")).isTrue();
    }
}
