package practice.daysOfStatistics;

import java.util.Arrays;
import java.util.Scanner;

public class Quartiles {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] X = new int[N];
		for (int i=0; i<N; i++) {
			X[i] = in.nextInt();
		}
		in.close();

		Arrays.sort(X);

		// compute median index first and derive the 1st and 3rd quantile index
		int q1 = 0, q2 = 0, q3 = 0;
		if (N%2==0) {
			int q2ind1 = N/2;
			int q2ind2 = N/2;
			q1 = (q2ind1%2==0) ? (X[q2ind1/2-1] + X[q2ind1/2])/2 : X[q2ind1/2];
			q2 = (X[N/2-1] + X[N/2])/2;
			q3 = ((N-q2ind2)%2==0) ? (X[(N+q2ind2)/2-1] + X[(N+q2ind2)/2])/2 : X[(N+q2ind2)/2];
		} else {
			int q2ind1 = N/2;
			int q2ind2 = N/2+1;
			q1 = (q2ind1%2==0) ? (X[q2ind1/2-1] + X[q2ind1/2])/2 : X[q2ind1/2];
			q2 = (X[N/2]);
			q3 = ((N-q2ind2)%2==0) ? (X[(N+q2ind2)/2-1] + X[(N+q2ind2)/2])/2 : X[(N+q2ind2)/2];

		}

		System.out.println(q1);
		System.out.println(q2);
		System.out.println(q3);
	}
}
