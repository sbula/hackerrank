package practice.algorithms.warmup;

import java.util.Scanner;

public class VeryBigSum {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int N = in.nextInt();
    	long sum = 0l;
    	for (int i=0; i<N; i++) {
    		sum += in.nextLong();
    	}
    	in.close();
    	
    	System.out.println(sum);
    }
}
