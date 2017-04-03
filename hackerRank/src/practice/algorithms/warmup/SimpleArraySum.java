package practice.algorithms.warmup;

import java.util.Scanner;

public class SimpleArraySum {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int N = in.nextInt();
    	long sum = 0;
    	for (int i=0; i<N; i++) {
    		sum += in.nextLong();
    	}
    	System.out.println(sum);
    	
    	in.close();
    }
}
