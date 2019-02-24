package helpers;

import java.util.Random;

public final class ProvavilityHelper {
    public static Boolean calculate(float number){
        Random rand = new Random();
        float chance = rand.nextFloat();
        return chance <= number;
    }
}
