package services;

import helpers.UuidHelper;
import model.GamePlay;
import model.GameType;
import model.Player;
import model.ProviderUser;
import model.configurations.GameConfigPoker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import runable.CasinoTest;
import services.bet.PlayerBet;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CasinoTest.class})

public class PlayerGameTimeTest {

    @Autowired
    private PlayerBet playerBetPoker;
    @Autowired
    private PlayerCreate playerCreate;
    @Autowired
    private PlayerTranstion playerTranstion;
    @Autowired
    private PlayerGameTime playerGameTime;

    private Player player;
    private GamePlay gamePlay;
    @Before
    public void configTest(){
        ProviderUser providerUser = new ProviderUser(UuidHelper.UUID(),"BET365");
        player = playerCreate.createPlayer(providerUser,0,2,1);

        GameConfigPoker configPoker = new GameConfigPoker(10,3, 10);
        gamePlay = new GamePlay(1, GameType.POKER,25,configPoker);
    }
    @Test
    public void whenPlayerGameBeforeLimitTimePlay(){
        playerBetPoker.playerBetGame(gamePlay,player,5);
        if(playerGameTime.checkPlayerWaitPlayTheGame(player,gamePlay)){
            playerTranstion.putTransitionGame(player,gamePlay,5);
        }

        playerBetPoker.playerBetGame(gamePlay,player,5);
        Boolean okPlay = playerGameTime.checkPlayerWaitPlayTheGame(player,gamePlay);
        assertFalse(okPlay);
    }

    @Test
    public void whenPlayerGameExcessTimePlay(){
        if(playerGameTime.checkPlayerExcessTimePlay(player,gamePlay)){
            playerBetPoker.playerBetGame(gamePlay,player,5);
            playerTranstion.putTransitionGame(player,gamePlay,5);
        }

        if(playerGameTime.checkPlayerExcessTimePlay(player,gamePlay)){
            playerBetPoker.playerBetGame(gamePlay,player,5);
            playerTranstion.putTransitionGame(player,gamePlay,5);
        }

        Boolean okPlay = playerGameTime.checkPlayerWaitPlayTheGame(player,gamePlay);
        if (okPlay)playerBetPoker.playerBetGame(gamePlay,player,5);

        assertFalse(okPlay);
    }

}