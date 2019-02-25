package services;

import helpers.GameTypeHelper;
import helpers.UuidHelper;
import model.GamePlay;
import model.GameType;
import model.Player;
import model.ProviderUser;
import model.configurations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.bet.*;

@Service
public final class CasinoGame {

    private PlayerBet playerBet;
    private PlayerCreate playerCreate;
    private PlayerCheckGameTime playerCheckGameTime;
    private PlayerPutTranstion playerPutTranstion;
    private Logger logger = LoggerFactory.getLogger(CasinoGame.class);

    @Autowired
    public CasinoGame(PlayerCreate playerCreate,PlayerCheckGameTime playerCheckGameTime,PlayerPutTranstion playerPutTranstion) {
        this.playerCreate = playerCreate;
        this.playerCheckGameTime = playerCheckGameTime;
        this.playerPutTranstion = playerPutTranstion;
    }

    public void startGame(int numberGame,int betGame){
        Boolean award = false;
        Player player1 = generateDummyPlayer();
        GamePlay gamePlay = checkGamePlay(numberGame);

        if(playerCheckGameTime.checkPlayerWaitPlayTheGame(player1,gamePlay) || playerCheckGameTime.checkPlayerExcessTimePlay(player1,gamePlay)){
            award = playerBet.playerBetGame(gamePlay,player1,betGame);
            playerPutTranstion.putTransitionGame(player1,gamePlay,betGame);
        }else{
            logger.info("excess game play or Wait play the game");
        }
        if(award){
            int awardCoin = checkAward(gamePlay);
            logger.info("Has ganado: "+awardCoin);
            player1.setBalance(awardCoin);
        }
    }

    private int checkAward(GamePlay gamePlay){
        return GameTypeHelper.getGameAward(gamePlay);
    }
    private Player generateDummyPlayer(){
        ProviderUser providerUser = new ProviderUser(UuidHelper.UUID(),"BET365");
        return playerCreate.createPlayer(providerUser,0,10,5);
    }
    private GamePlay checkGamePlay(int number){
        switch (number){
            case 1:
                playerBet = new PlayerBetVideoBingo();
                GameConfigVideoBingo configVideoBingo = new GameConfigVideoBingo(10,3, 10);
                return new GamePlay(1, GameType.VIDEOBINGO,50,configVideoBingo);
            case 2:
                playerBet = new PlayerBetSlot();
                GameConfigSlot configSlot = new GameConfigSlot(10,3, 10);
                return new GamePlay(2, GameType.SLOT,10,configSlot);
            case 3:
                playerBet = new PlayerBetBlackjack();
                GameConfigBlackjack configBlackjack = new GameConfigBlackjack(10,3, 10);
                return new GamePlay(3, GameType.BLACKJACK,20,configBlackjack);
            case 4:
                playerBet = new PlayerBetPoker();
                GameConfigPoker configPoker = new GameConfigPoker(10,3, 10);
                return new GamePlay(4, GameType.POKER,10,configPoker);
            case 5:
                playerBet = new PlayerBetRuleta();
                GameConfigRuleta configRuleta = new GameConfigRuleta(10,1, 10);
                return new GamePlay(5, GameType.RULETA,30,configRuleta);
            default:
                return null;
        }
    }
}
