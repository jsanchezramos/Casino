package services;

import model.GamePlay;
import model.Player;
import model.entity.Transition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repository.GameTransitionsRepository;

import java.util.Date;
import java.util.List;


@Service
public final class PlayerTranstion {
    private Logger logger = LoggerFactory.getLogger(PlayerTranstion.class);
    private GameTransitionsRepository gameTransitionsRepository;

    @Autowired
    public PlayerTranstion(GameTransitionsRepository gameTransitionsRepository) {
        this.gameTransitionsRepository = gameTransitionsRepository;
    }

    public void putTransitionGame(Player player, GamePlay gamePlay, int increment) {
        Transition transition = new Transition(player.getUserId(),gamePlay.getGameType().toString(),increment, new Date());
        Transition ok = gameTransitionsRepository.save(transition);
        logger.info("Transition "+ ok.getIdTransition()+ " User:"+ ok.getUserId() + " Increment: "+increment + " Game: "+ok.getNamePlay()+" Time: "+ok.getLastPlay() );
    }
    public Transition getLastTimeTransition(Player player,GamePlay gamePlay){
        List<Transition> transtionItem = gameTransitionsRepository.findByUserIdAndNamePlayOrderByLastPlayDesc(player.getUserId(),gamePlay.getGameType().toString());
        return (transtionItem.size() != 0)? transtionItem.get(0): null;
    }
}
