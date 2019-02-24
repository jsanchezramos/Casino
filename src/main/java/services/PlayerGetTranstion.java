package services;

import model.GamePlay;
import model.Player;
import model.entity.Transition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.GameTransitionsRepository;

import java.util.List;


@Service
public final class PlayerGetTranstion {
    private Logger logger = LoggerFactory.getLogger(PlayerGetTranstion.class);
    private GameTransitionsRepository gameTransitionsRepository;

    @Autowired
    public PlayerGetTranstion(GameTransitionsRepository gameTransitionsRepository) {
        this.gameTransitionsRepository = gameTransitionsRepository;
    }

    public Transition getLastTimeTransition(Player player,GamePlay gamePlay){
        List<Transition> transtionItem = gameTransitionsRepository.findByUserIdAndNamePlayOrderByLastPlayDesc(player.getUserId(),gamePlay.getGameType().toString());
        return (transtionItem.size() != 0)? transtionItem.get(0): null;
    }
}
