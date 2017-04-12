package practice.algorithms.search;

import java.util.Scanner;
import java.util.TreeSet;

public class MinimumLoss {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int years = in.nextInt();
    	TreeSet<Long> priceSet = new TreeSet<Long>();
    	long minDiff = Long.MAX_VALUE;
    	for (int i=0; i<years; i++) {
    		long price = in.nextLong();
    		Long higherPrice = priceSet.ceiling(price);
    		if (higherPrice != null && higherPrice > price && (higherPrice-price)<minDiff) {
    			minDiff = higherPrice-price;
    		}
    		priceSet.add(price);
    	}
    	in.close();
    	
    	System.out.println(minDiff);
    }
}
