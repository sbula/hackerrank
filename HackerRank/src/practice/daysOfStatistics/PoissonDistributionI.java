package daysOfStatistics;

import java.util.Scanner;

public class PoissonDistributionI {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double mean = in.nextDouble();
		int x = in.nextInt();
		in.close();
		
		long faculty = 1;
		for (int i=2; i<=x; i++) faculty *= i;
		
		double proba = Math.pow(mean, x) * Math.pow(Math.E, -mean) / (double)faculty;
		
		System.out.format("%.3f", proba);
	}
	/**
	 * 2.5
	 * 5
	 * 
	 * 0.067
	 */
}
