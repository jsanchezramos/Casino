package helpers;
import java.util.UUID;

public final class UuidHelper {
    public static String UUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
