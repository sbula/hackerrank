package practice.algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class VerticalSticks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i=0; i<T; i++) {
			int N = in.nextInt();
			int[] A = new int[N];
			for (int k=0; k<N; k++) {
				A[k] = in.nextInt();
			}
			
			// for each stick divide the total number of sticks by the number of sticks with greater or equal high
			Arrays.sort(A);
			int ind=0;
			double sum = 0.0;
			int height = Integer.MIN_VALUE;
			double proba = 0.0;
			while (ind<N) {
				if (A[ind] > height) {
					height = A[ind];
					proba = (N+1d)/(N-ind+1d);
				}
				ind++;
				sum += proba;
			}
			
			System.out.println(String.format("%.2f", sum));
		}
		
		in.close();
	}
}
