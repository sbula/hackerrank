package practice.javaPath.introduction;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class DateAndTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        in.close();
        
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(year), Integer.parseInt(month)-1, Integer.parseInt(day));
        String output = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()).toUpperCase();
        
        System.out.println(output);
    }
}
