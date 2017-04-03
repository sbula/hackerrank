package practice.algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

public class MissingNumbers {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int sizeA = in.nextInt();
    	int[] arrayA = new int[sizeA];
    	for (int i=0; i<arrayA.length; i++) {
    		arrayA[i] = in.nextInt();
    	}
    	int sizeB = in.nextInt();
    	int[] arrayB = new int[sizeB];
    	for (int i=0; i<arrayB.length; i++) {
    		arrayB[i] = in.nextInt();
    	}
    	in.close();

    	Arrays.sort(arrayA);
    	Arrays.sort(arrayB);
    	int lastPrinted = -1;
    	int indexA=0, indexB=0;
    	while (indexA<arrayA.length || indexB<arrayB.length) {
    		if (indexA<arrayA.length && arrayA[indexA] == arrayB[indexB]) {
    			indexA++;
    			indexB++;
    		} else if (lastPrinted == arrayB[indexB]) {
    			indexB++;
    		} else {
    			System.out.print(arrayB[indexB] + " ");
    			lastPrinted = arrayB[indexB];
    			indexB++;
    		}
    	}
    }
}
