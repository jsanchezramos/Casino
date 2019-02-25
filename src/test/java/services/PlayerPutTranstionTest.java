package services;

import model.GamePlay;
import model.GameType;
import model.Player;
import model.configurations.GameConfigSlot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import runable.CasinoTest;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CasinoTest.class})
public class PlayerPutTranstionTest {
    @Autowired
    private PlayerPutTranstion playerPutTranstion;
    @Autowired
    private PlayerCreate playerCreate;

    @Test
    public void putTransitionIsNotExist(){
        Player player = playerCreate.createPlayer(null,0,10,5);
        GameConfigSlot configSlot = new GameConfigSlot(10,3, 10);
        GamePlay gamePlay = new GamePlay(1, GameType.POKER,100,configSlot);

        try{
            playerPutTranstion.putTransitionGame(player,gamePlay,5);
        }catch (Exception ex){
            assertThat(ex.getMessage(), is("java.lang.NullPointerException: null"));
        }
    }

}