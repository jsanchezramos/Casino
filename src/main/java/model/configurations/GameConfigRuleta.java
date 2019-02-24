package model.configurations;

public final class GameConfigRuleta {
    private int maxBet;
    private int minBet;
    private int award;

    public GameConfigRuleta(int maxBet, int minBet, int award) {
        this.maxBet = maxBet;
        this.minBet = minBet;
        this.award = award;
    }

    public int getMaxBet() {
        return maxBet;
    }

    public int getMinBet() {
        return minBet;
    }

    public int getAward() {
        return award;
    }
}
