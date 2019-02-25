package services.bet;

import helpers.UuidHelper;
import model.GamePlay;
import model.GameType;
import model.Player;
import model.ProviderUser;
import model.configurations.GameConfigBlackjack;
import model.configurations.GameConfigPoker;
import model.configurations.GameConfigVideoBingo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import runable.CasinoTest;
import services.PlayerCreate;
import services.PlayerPutTranstion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CasinoTest.class})

public class PlayerBetVideoBingoTest {

    @Autowired @Qualifier("playerBetVideoBingo")
    private PlayerBet playerBetVideoBingo;
    @Autowired
    private PlayerCreate playerCreate;
    @Autowired
    private PlayerPutTranstion playerPutTranstion;

    /**
     * Player bet win 100% award
     */
    @Test
    public void playerBetGameAndCentPercentProbability(){
        ProviderUser providerUser = new ProviderUser(UuidHelper.UUID(),"BET365");
        Player player = playerCreate.createPlayer(providerUser,0,10,5);

        GameConfigVideoBingo configVideoBingo = new GameConfigVideoBingo(10,3, 10);
        GamePlay gamePlay = new GamePlay(1,GameType.POKER,100,configVideoBingo);

        Boolean award = playerBetVideoBingo.playerBetGame(gamePlay,player,5);
        if(award)player.setBalance(configVideoBingo.getAward());
        playerPutTranstion.putTransitionGame(player,gamePlay,5);
        assertTrue(award);
    }

    /**
     * All bet game is 100% not win award
     */
    @Test
    public void playerBetGameAndCeroPercentProbability(){
        ProviderUser providerUser = new ProviderUser(UuidHelper.UUID(),"BET365");
        Player player = playerCreate.createPlayer(providerUser,0,10,5);

        GameConfigVideoBingo configVideoBingo = new GameConfigVideoBingo(10,3, 10);
        GamePlay gamePlay = new GamePlay(1,GameType.POKER,0,configVideoBingo);

        Boolean award = playerBetVideoBingo.playerBetGame(gamePlay,player,5);
        playerPutTranstion.putTransitionGame(player,gamePlay,5);
        assertFalse(award);
    }

}