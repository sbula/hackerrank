package algorithms.warmup;

import java.util.Scanner;

public class MinMaxSum {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long sum = 0l;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int i=0; i<5; i++) {
        	long input = in.nextLong();
        	sum += input;
        	if (min > input) min = input;
        	if (max < input) max = input;
        }
        in.close();
        
        System.out.println((sum - max) + " " + (sum - min)); 
    }
}
