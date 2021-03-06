package practice.daysOfStatistics;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BinomialDistributionI {
    private static DecimalFormat df3 = new DecimalFormat(".###");
    private static int kidsCount = 6;

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	double ratioPart1 = in.nextDouble();
    	double ratioPart2 = in.nextDouble();
    	in.close();

    	double probaBoy = ratioPart1 / (ratioPart1+ratioPart2);
    	double probaGirl = ratioPart2 / (ratioPart1+ratioPart2);
    	
    	double girlRes = 0;
    	for (int i=kidsCount; i>3; i--) {
    		girlRes +=  permut(kidsCount, i) * (Math.pow(probaGirl, i)) * (Math.pow(probaBoy, kidsCount-i));
    	}
    	
    	System.out.println("0" + df3.format(1-girlRes));
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
