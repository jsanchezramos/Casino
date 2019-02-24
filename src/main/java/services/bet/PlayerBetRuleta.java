package services.bet;

import helpers.ProvavilityHelper;
import model.GamePlay;
import model.Player;
import model.configurations.GameConfigRuleta;
import org.springframework.stereotype.Service;


@Service
public final class PlayerBetRuleta implements PlayerBet{

    public Boolean playerBetGame(GamePlay gamePlay, Player player, int bet){
        Boolean award = false;

        GameConfigRuleta gameConfig = (GameConfigRuleta) gamePlay.getGameConfiguration();
        if(bet > gameConfig.getMinBet() && bet < gameConfig.getMaxBet()){
            award = ProvavilityHelper.calculate(gamePlay.getPercentProbability());
        }
        return award;
    }
}
