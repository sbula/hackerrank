package daysOfStatistics;

import java.text.DecimalFormat;
import java.util.Scanner;

public class StandardDeviation {
    private static DecimalFormat df1 = new DecimalFormat(".#");
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] input = new int[N];
        int sum = 0;
        for (int i=0; i<N; i++) {
            input[i] = in.nextInt();
            sum += input[i];
        }
        in.close();
        
        double mean = (double)sum/(double)N;
        
        double squareSum = 0;
        for (int i=0; i<N; i++) {
        	squareSum += ((double)input[i] - mean) * ((double)input[i] - mean);
        }
        
        double deviation = Math.sqrt((squareSum)/(double)N);
        
        System.out.println(df1.format(deviation));
    }
}
