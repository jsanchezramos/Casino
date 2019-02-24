package services;

import model.GamePlay;
import model.Player;
import model.entity.Transition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public final class PlayerCheckGameTime {

    private PlayerGetTranstion playerGetTranstion;

    @Autowired
    public PlayerCheckGameTime(PlayerGetTranstion playerGetTranstion) {
        this.playerGetTranstion = playerGetTranstion;
    }
    public Boolean checkPlayerWaitPlayTheGame(Player player, GamePlay gamePlay){
        Transition lastDateGame = playerGetTranstion.getLastTimeTransition(player,gamePlay);
        if(lastDateGame != null){
            long differents = (Math.abs(lastDateGame.getLastPlay().getTime() - new Date().getTime())) / 60000;
            return differents > player.getTimeWaitToPlay();
        }else
            return true;
    }
    public Boolean checkPlayerExcessTimePlay(Player player,GamePlay gamePlay){
        Transition lastDateGame = playerGetTranstion.getLastTimeTransition(player,gamePlay);
        if(lastDateGame != null){
            long differents = (Math.abs(lastDateGame.getLastPlay().getTime() - new Date().getTime())) / 60000;
            return differents <= player.getTimeToPlay();
        }else
            return true;
    }
}
