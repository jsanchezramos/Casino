package services;
import helpers.UuidHelper;
import model.Player;
import model.ProviderUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import runable.CasinoTest;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CasinoTest.class})
public class PlayerCreateTest {

    @Autowired
    private PlayerCreate playerCreate;

    @Test
    public void createNewPlayerInCasino(){
        ProviderUser providerUser = new ProviderUser(UuidHelper.UUID(),"BET365");
        Player player = playerCreate.createPlayer(providerUser,0,10,5);
        assertNotNull(player);
    }

    @Test
    public void createPlayerIsNotProvider(){
        Player player = playerCreate.createPlayer(null,0,10,5);
        assertNull(player);
    }

}
