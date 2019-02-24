package services;
import helpers.UuidHelper;
import model.Player;
import model.ProviderUser;
import org.springframework.stereotype.Service;

@Service
public final class PlayerCreate {

     public Player createPlayer(ProviderUser provider, int balance, int timeToPlay, int timeWaitToPlay){
        if (provider != null) {
            return new Player(UuidHelper.UUID(),balance,timeToPlay,timeWaitToPlay,provider);
        } else {
            return null;
        }
    }
}
