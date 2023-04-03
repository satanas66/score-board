package es.sport.radar.service;

import es.sport.radar.domain.Game;
import es.sport.radar.domain.Team;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class ScoreBoardImpl implements ScoreBoard {

    private Map<String, Game> initialScoreBoard;

    private Map<String, Game> finalScoreBoard;

    public ScoreBoardImpl() {
        this.initialScoreBoard = new LinkedHashMap<>();
        this.finalScoreBoard = new LinkedHashMap<>();
    }

    public Map<String, Game> getInitialScoreBoard() {
        return initialScoreBoard;
    }

    @Override
    public void startGame(String teamName1, String teamName2) {
        if (evaluateString(teamName1) && evaluateString(teamName2)) {
            Team homeTeam = new Team(teamName1);
            Team awayTeam = new Team(teamName2);
            Game game = new Game(homeTeam, awayTeam);
            if (Objects.isNull(this.initialScoreBoard.get(game.getIdGame()))) {
                this.initialScoreBoard.put(game.getIdGame(), game);
            }
        }
    }

    @Override
    public void finishGame(String idGame) {
        if (evaluateString(idGame) && Objects.nonNull(this.initialScoreBoard.get(idGame))) {
            this.finalScoreBoard.put(idGame, this.initialScoreBoard.get(idGame));
            this.initialScoreBoard.remove(idGame);
        }
    }

    @Override
    public void updateScore(String idGame, Integer homeTeamScore, Integer awayTeamScore) {

    }

    @Override
    public List<String> summaryGames() {
        return null;
    }

    private boolean evaluateString(String value) {
        return (StringUtils.isNotBlank(value) && StringUtils.isNotEmpty(value));
    }
}
