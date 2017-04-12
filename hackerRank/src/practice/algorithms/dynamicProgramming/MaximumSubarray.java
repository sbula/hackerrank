package practice.algorithms.dynamicProgramming;

import java.util.Scanner;

public class MaximumSubarray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int i=0; i<T; i++) {
			int N = in.nextInt();
			int[] A = new int[N];
			for (int k=0; k<N; k++) {
				A[k] = in.nextInt();
			}
			
			// Kadane's algorithm
			int maxSum=A[0];
			int tmpSum=A[0];
			int nonContSum=A[0];
			for (int k=1; k<N; k++) {
				tmpSum = (tmpSum<=0) ? A[k] : tmpSum+A[k];
				maxSum = Math.max(maxSum, tmpSum);
				nonContSum =  (nonContSum<=0) ? Math.max(A[k], nonContSum) : (A[k]<=0) ? nonContSum : nonContSum+A[k];
			}
			
			System.out.println(maxSum + " " + nonContSum);
		}
		in.close();
	}
}
