import java.time.ZoneId;
import java.time.ZonedDateTime;

public class GMT{
    public static void main(String[] args) {
        // Get current time in GMT/UTC
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("UTC"));

        int hour = gmtTime.getHour();
        int minute = gmtTime.getMinute();
        int second = gmtTime.getSecond();

        // Print in HH:mm:ss format (always two digits)
        System.out.printf("%d:%d:%2d%n", hour, minute, second);
    }
}

