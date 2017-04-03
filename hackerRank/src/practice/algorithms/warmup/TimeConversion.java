package practice.algorithms.warmup;

import java.util.Scanner;

public class TimeConversion {

	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	String input = in.nextLine();
    	in.close();
    	
		int hour = Integer.parseInt(input.substring(0, 2));
		int min = Integer.parseInt(input.substring(3, 5));
		int sec = Integer.parseInt(input.substring(6, 8));
		

    	if (hour == 0 && min == 0 && sec == 0) {
    		hour = 12;
    	}
    	
    	if  (hour == 12 && ((min != 0 && sec != 0) || input.endsWith("AM"))) {
    		hour = 0;
    	}
    	
    	if (input.endsWith("PM")) {
    		hour += 12;
    	}
    	
    	System.out.println( String.format("%02d", hour) + ":"+  String.format("%02d", min) + ":"+  String.format("%02d", sec));
    }

}
