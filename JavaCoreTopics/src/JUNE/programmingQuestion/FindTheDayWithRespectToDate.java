package JUNE.programmingQuestion;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * @author sidharthdas on 30/06/21.
 */
public class FindTheDayWithRespectToDate {


    public static void main ( String[] args ) {


        Date date=new Date();
        System.out.println(date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        System.out.println("Day of week in number:"+dayOfWeek);
        String dayWeekText = new SimpleDateFormat("EEEE").format(date);
        System.out.println("Day of week in text:"+dayWeekText);

    }



}
