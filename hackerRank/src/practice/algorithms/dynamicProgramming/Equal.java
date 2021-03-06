package practice.algorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Equal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sampleCount = in.nextInt();
        for (int i=0; i<sampleCount; i++) {
        	int colleagues = in.nextInt();
        	if (colleagues<2) {
        		System.out.println(0);
        		continue;
        	}
        	int[] chocArray = new int[colleagues];
        	for (int k=0; k<colleagues; k++) {
        		chocArray[k] = in.nextInt();
        	}
        	
        	Arrays.sort(chocArray);
        	int counter = Integer.MAX_VALUE;
        	for (int base=0; base<3; base++) {
        		int myCounter = (base>0) ? 1 : 0;
        		for (int k=1; k<chocArray.length; k++) {
        			int diff = chocArray[k] - chocArray[0] + base;
        			myCounter += diff/5 + (diff%5)/2 + diff%5%2;
        		}
        		counter = (counter < myCounter) ? counter : myCounter;
        	}
        	
        	System.out.println(counter);
        }
        in.close();
    }
}
