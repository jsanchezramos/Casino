package services.bet;

import model.GamePlay;
import model.Player;

public interface PlayerBet {
    Boolean playerBetGame(GamePlay gamePlay, Player player, int bet);
}
