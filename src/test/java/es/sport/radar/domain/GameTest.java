package es.sport.radar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class GameTest {

    private static Team homeTeam;

    private static Team awayTeam;

    private static Game game;

    @BeforeEach
    void setUpEach() {
        homeTeam = new Team("ECUADOR");
        awayTeam = new Team("PERÚ");
        game = new Game(homeTeam, awayTeam);
    }

    @Test
    void testVerifyNonNullTeams() {
        assertThat(game.getHomeTeam()).isNotNull();
        assertThat(game.getAwayTeam()).isNotNull();

        assertThat(game.getHomeTeam().getName()).isNotNull();
        assertThat(game.getAwayTeam().getName()).isNotNull();

        assertThat(game.getHomeTeam().getScore()).isNotNull();
        assertThat(game.getAwayTeam().getScore()).isNotNull();
    }

    @Test
    void testToStringStart() {
        assertThat(game.toStringCurrent()).isNotNull().isNotEmpty();
        assertThat(game.toStringCurrent()).isEqualToIgnoringCase("ECUADOR - PERÚ: 0 - 0");
    }

    @Test
    void testToStringUpdate() {
        assertThat(game.toStringSummary()).isNotNull().isNotEmpty();
        assertThat(game.toStringSummary()).isEqualToIgnoringCase("ECUADOR 0 - PERÚ 0");
    }

    @Test
    void testSetTie(){
        assertThat(game.isTie()).isFalse();
        game.setTie(true);
        assertThat(game.isTie()).isTrue();
    }
}
