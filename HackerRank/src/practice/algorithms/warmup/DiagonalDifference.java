package algorithms.warmup;

import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int sum1 = 0, sum2 = 0;
        
        for (int i=0; i<N; i++) {
        	for (int k=0; k<N; k++) {
        		int tmp = in.nextInt();
        		if ((i-k)==0) sum1 += tmp;
        		if ((i+k)==N-1) sum2 += tmp;
        	}
        }
        in.close();
        
        System.out.println(Math.abs(sum1 - sum2));
    }
}
