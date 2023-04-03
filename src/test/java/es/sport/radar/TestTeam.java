package es.sport.radar;

import es.sport.radar.domain.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class TestTeam {

    private static Team team;

    @BeforeEach
    void setUp() {
        team = new Team("ECUADOR");
    }

    @Test
    void testTeamNonNull() {
        assertThat(team).isNotNull();
    }

    @Test
    void testGetName() {
        assertThat(team.getName()).isEqualToIgnoringCase("ECUADOR");
    }

    @Test
    void testGetScore() {
        assertThat(team.getScore()).isNotNull().isEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(team.toString()).isEqualToIgnoringCase("ECUADOR 0");
    }
}
