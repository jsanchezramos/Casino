package helpers;
import model.GamePlay;
import model.configurations.*;

public final class GameTypeHelper {
    public static int getGameAward(GamePlay gamePlay){
        switch (gamePlay.getGameType()){
            case VIDEOBINGO :
                GameConfigVideoBingo gameConfigVB = (GameConfigVideoBingo) gamePlay.getGameConfiguration();
                return gameConfigVB.getAward();
            case POKER:
                GameConfigPoker gameConfigPoker = (GameConfigPoker) gamePlay.getGameConfiguration();
                return gameConfigPoker.getAward();
            case RULETA:
                GameConfigRuleta gameConfigRuleta = (GameConfigRuleta) gamePlay.getGameConfiguration();
                return gameConfigRuleta.getAward();
            case BLACKJACK:
                GameConfigBlackjack gameConfigBlackjack = (GameConfigBlackjack) gamePlay.getGameConfiguration();
                return gameConfigBlackjack.getAward();
            case SLOT:
                GameConfigSlot gameConfigSlot = (GameConfigSlot) gamePlay.getGameConfiguration();
                return gameConfigSlot.getAward();
            default:
                return 0;
        }
    }
}
