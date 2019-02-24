package services.bet;

import helpers.ProvavilityHelper;
import model.GamePlay;
import model.Player;
import model.configurations.GameConfigPoker;

import org.springframework.stereotype.Service;


@Service
public final class PlayerBetPoker implements PlayerBet{

    public Boolean playerBetGame(GamePlay gamePlay, Player player, int bet){
        Boolean award = false;

        GameConfigPoker gameConfig = (GameConfigPoker) gamePlay.getGameConfiguration();
        if(bet > gameConfig.getMinBet() && bet < gameConfig.getMaxBet()){
            award = ProvavilityHelper.calculate(gamePlay.getPercentProbability());
        }
        return award;
    }
}
