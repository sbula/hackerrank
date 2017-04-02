package daysOfStatistics;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BinomialDistributionII {
    private static DecimalFormat df3 = new DecimalFormat(".###");

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int rejectPerc = in.nextInt();
    	int quant = in.nextInt();
    	in.close();

    	double rejectProba = rejectPerc / 100.0;
    	double acceptProba = (100-rejectPerc) / 100.0;
    	
    	double atMost = 0.0;
    	for (int i=0; i<=2; i++) {
    		atMost +=  permut(quant, i) * (Math.pow(rejectProba, i)) * (Math.pow(acceptProba, quant-i));
    	}
    	
    	double atLeast = 1.0;
    	for (int i=0; i<2; i++) {
    		atLeast -=  permut(quant, i) * (Math.pow(rejectProba, i)) * (Math.pow(acceptProba, quant-i));
    	}
    	
    	System.out.println("0" + df3.format(atMost));
    	System.out.println("0" + df3.format(atLeast));
    }
    
    
    private static double permut(int n, int r) {
    	long divident = 1, divisor = 1;
    	
    	int a = (n-r>r) ? n-r+1 : r+1;
    	int b = (n-r>r) ? r : n-r;
    	
    	for (int i=a; i<=n; i++) {
    		divident *= i;
    	}
    	for (int i=1; i<=b; i++) {
    		divisor *= i;
    	}
    	return (double)divident / (double)divisor;
    }
}
