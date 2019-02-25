package model;

public final class Player {
    private String userId;
    private int balance;
    private int timeToPlay;
    private int timeWaitToPlay;
    private ProviderUser providerUser;

    public Player(String userId, int balance, int timeToPlay, int timeWaitToPlay, ProviderUser providerUser) {
        this.userId = userId;
        this.balance = balance;
        this.timeToPlay = timeToPlay;
        this.timeWaitToPlay = timeWaitToPlay;
        this.providerUser = providerUser;
    }

    public int getBalance() {
        return balance;
    }

    public int getTimeToPlay() {
        return timeToPlay;
    }

    public int getTimeWaitToPlay() {
        return timeWaitToPlay;
    }

    public String getUserId() {
        return userId;
    }

    public ProviderUser getProviderUser() {
        return providerUser;
    }
    public void setBalance(int balance) {
        this.balance = this.balance + balance;
    }
}
