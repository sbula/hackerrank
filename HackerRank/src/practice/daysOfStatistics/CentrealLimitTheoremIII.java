package daysOfStatistics;

public class CentrealLimitTheoremIII {
	public static void main(String[] args) {
		double sample  = 100;
		double mean    = 500;
		double stdDev  = 80;
		double confInt = .95;
		double zScore  = 1.96;
		
		double marginErr = zScore * stdDev /Math.sqrt(sample);

		System.out.format("%.2f%n", mean - marginErr);
		System.out.format("%.2f%n", mean + marginErr);
	}
}
