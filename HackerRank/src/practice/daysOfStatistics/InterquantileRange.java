package practice.daysOfStatistics;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class InterquantileRange {
    private static DecimalFormat df2 = new DecimalFormat(".#");
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] X = new int[N];
		for (int i=0; i<N; i++) {
			X[i] = in.nextInt();
		}
		int[] F = new int[N];
		int sizeS = 0;
		for (int i=0; i<N; i++) {
			F[i] = in.nextInt();
			sizeS += F[i];
		}
		in.close();
    	
		double[] S = new double[sizeS];
		int index = 0;
		for (int i=0; i<N; i++) {
			for (int k=0; k<F[i]; k++) {
				S[index] = X[i];
				index++;
			}
		}
		Arrays.sort(S);

		double q1 = 0, q3 = 0;
		if (sizeS%2==0) {
			int q2ind1 = sizeS/2;
			int q2ind2 = sizeS/2;
			q1 = (q2ind1%2==0) ? (S[q2ind1/2-1] + S[q2ind1/2])/2d : S[q2ind1/2];
			q3 = ((sizeS-q2ind2)%2==0) ? (S[(sizeS+q2ind2)/2-1] + S[(sizeS+q2ind2)/2])/2d : S[(sizeS+q2ind2)/2];
		} else {
			int q2ind1 = sizeS/2;
			int q2ind2 = sizeS/2+1;
			q1 = (q2ind1%2==0) ? (S[q2ind1/2-1] + S[q2ind1/2])/2d : S[q2ind1/2];
			q3 = ((sizeS-q2ind2)%2==0) ? (S[(sizeS+q2ind2)/2-1] + S[(sizeS+q2ind2)/2])/2d : S[(sizeS+q2ind2)/2];
		}
		
		System.out.println(df2.format(q3-q1));
    }
}
