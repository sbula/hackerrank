package daysOfStatistics;

import java.text.DecimalFormat;
import java.util.Scanner;

public class WeightedMean {

    private static DecimalFormat df2 = new DecimalFormat(".#");

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int[] X = new int[N];
		for (int i=0; i<N; i++) {
			X[i] = in.nextInt();
		}
		int[] W = new int[N];
		for (int i=0; i<N; i++) {
			W[i] = in.nextInt();
		}
		in.close();

		int res = 0;
		int weight = 0;
		for (int i=0; i<N; i++) {
			res = X[i] * W[i];
			weight += W[i];
		}
		
        System.out.println(df2.format((double)res/(double)weight));
	}
}
