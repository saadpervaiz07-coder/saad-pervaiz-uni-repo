
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class GMTTime {

    public static void main(String[] args) {

        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("UTC"));

        int hrs = gmtTime.getHour();

        int min = gmtTime.getMinute();

        int sec = gmtTime.getSecond();

        //use printf to print time and uses format specifier to print 2 digit integer
        System.out.printf("%02d:%02d:%02d\n", hrs, min, sec);

        //use println to print time and do simple concatenation
        System.out.println(hrs + ":" + min + ":" + sec);
    }

}


