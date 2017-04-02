package algorithms.implementation;

import java.util.Scanner;

public class StrangeCounter {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	long nbr = in.nextLong();
    	in.close();
    	
    	long sum = 0;
    	for (long i=0; sum<nbr; i++) {
    		sum += 3*(long)Math.ceil(Math.pow(2, i));
    	}

    	System.out.println(sum-nbr+1);
    }
}
