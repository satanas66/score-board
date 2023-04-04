package es.sport.radar.domain;

/**
 * @author EDWIN PATRICIO ARÉVALO ANGULO
 */
public class Game {

    private String idGame;

    private boolean tie;

    private Team homeTeam;

    private Team awayTeam;

    public Game(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.tie = false;
        this.idGame = homeTeam.getName().substring(0, 4) + "_" + awayTeam.getName().substring(0, 4);
    }

    public String getIdGame() {
        return idGame;
    }

    public boolean isTie() {
        return tie;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setTie(boolean tie) {
        this.tie = tie;
    }

    public String toStringCurrent() {
        return getHomeTeam().getName() + " - " + getAwayTeam().getName() + ": " + getHomeTeam().getScore() + " - " + getAwayTeam().getScore();
    }

    public String toStringSummary() {
        return getHomeTeam().toString()+ " - " + getAwayTeam().toString();
    }
}
