package services.bet;

import helpers.ProvavilityHelper;
import model.GamePlay;
import model.Player;
import model.configurations.GameConfigSlot;
import org.springframework.stereotype.Service;


@Service
public final class PlayerBetSlot implements PlayerBet{

    public Boolean playerBetGame(GamePlay gamePlay, Player player, int bet){
        Boolean award = false;

        GameConfigSlot gameConfig = (GameConfigSlot) gamePlay.getGameConfiguration();
        if(bet > gameConfig.getMinBet() && bet < gameConfig.getMaxBet()){
            award = ProvavilityHelper.calculate(gamePlay.getPercentProbability());
        }
        return award;
    }
}
