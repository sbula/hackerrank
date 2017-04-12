package practice.algorithms.dynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        BigInteger t1 = BigInteger.valueOf(in.nextLong());
        BigInteger t2 = BigInteger.valueOf(in.nextLong());
        int n = in.nextInt();
        in.close();
        
        for (int i=2; i<n; i++) {
        	BigInteger tmp = t2;
        	t2 = t1.add(t2.pow(2));
        	t1 = tmp;
        }
        System.out.println(t2);
	}
}
