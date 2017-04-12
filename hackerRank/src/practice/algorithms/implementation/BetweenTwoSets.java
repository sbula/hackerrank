package practice.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BetweenTwoSets {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        Arrays.sort(b);
        in.close();
        
        long lcm = a[0];
        for(int k=1; k<a.length; k++) {
        	lcm = lcm(lcm, a[k]);
        }

    	int counter = 0;
        if (lcm <= 100) {
        	int test = (int)lcm;
        	while (test<=b[0]) {
    			boolean isDivisor = true;
        		for (int k=0; k<b.length; k++) {
        			if (b[k]%test!=0) {
        				isDivisor = false;
        				break;
        			}
        		}
        		if (isDivisor) counter++;
        		test += lcm;
        	}
        }
        
    	System.out.println(counter);
	}

	private static long gcd(long a, long b) {
		while (b>0) {
			long t=b;
			b = a%b;
			a = t;
		}
		return a;
	}
	
	private static long lcm(long a, long b) {
	    return a * (b / gcd(a, b));
	}
}
