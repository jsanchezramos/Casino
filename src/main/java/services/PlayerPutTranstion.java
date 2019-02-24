package services;

import model.GamePlay;
import model.Player;
import model.entity.Transition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.GameTransitionsRepository;

import java.util.Date;


@Service
public final class PlayerPutTranstion {
    private Logger logger = LoggerFactory.getLogger(PlayerPutTranstion.class);
    private GameTransitionsRepository gameTransitionsRepository;

    @Autowired
    public PlayerPutTranstion(GameTransitionsRepository gameTransitionsRepository) {
        this.gameTransitionsRepository = gameTransitionsRepository;
    }

    public void putTransitionGame(Player player, GamePlay gamePlay, int increment) {
        Transition transition = new Transition(player.getUserId(),gamePlay.getGameType().toString(),increment, new Date());
        Transition ok = gameTransitionsRepository.save(transition);
        logger.info("Transition "+ ok.getIdTransition()+ " User:"+ ok.getUserId() + " Increment: "+increment + " Game: "+ok.getNamePlay()+" Time: "+ok.getLastPlay() );
    }
}
