package model.configurations;

public final class GameConfigBlackjack {
    private int maxBet;
    private int minBet;
    private int award;

    public GameConfigBlackjack(int maxBet, int minBet, int award) {
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
