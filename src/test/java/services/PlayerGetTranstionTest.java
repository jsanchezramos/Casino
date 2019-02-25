package services;

import model.GamePlay;
import model.GameType;
import model.Player;
import model.configurations.GameConfigSlot;
import model.entity.Transition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import runable.CasinoTest;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CasinoTest.class})
public class PlayerGetTranstionTest {

    @Autowired
    private PlayerGetTranstion playerGetTranstion;
    @Autowired
    private PlayerCreate playerCreate;
    @Test
    public void getTransitionForPlayerNull(){
        Player player = playerCreate.createPlayer(null,0,10,5);
        GameConfigSlot configSlot = new GameConfigSlot(10,3, 10);
        GamePlay gamePlay = new GamePlay(1, GameType.POKER,100,configSlot);

        Transition transition = playerGetTranstion.getLastTimeTransition(player,gamePlay);
        assertNull(transition);
    }
}