package model;

public final class GamePlay {
    private int gameId;
    private GameType gameType;
    private int percentProbability;
    private Object gameConfiguration;

    public GamePlay(int gameId, GameType gameType, int percentProbability, Object gameConfiguration) {
        this.gameId = gameId;
        this.gameType = gameType;
        this.percentProbability = percentProbability;
        this.gameConfiguration = gameConfiguration;
    }

    public GameType getGameType() {
        return gameType;
    }

    public int getPercentProbability() {
        return percentProbability;
    }

    public Object getGameConfiguration() {
        return gameConfiguration;
    }
}
