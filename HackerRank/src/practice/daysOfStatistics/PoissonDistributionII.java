package daysOfStatistics;

import java.util.Scanner;

public class PoissonDistributionII {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double X = in.nextDouble();
		double Y = in.nextDouble();
		in.close();

		double costA = 160d + 40d * (X + Math.pow(X, 2));
		double costB = 128d + 40d * (Y + Math.pow(Y, 2));

		System.out.format("%.3f", costA);
		System.out.println();
		System.out.format("%.3f", costB);
	}
}
