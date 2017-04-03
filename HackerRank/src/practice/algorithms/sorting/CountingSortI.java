package practice.algorithms.sorting;

import java.util.Scanner;

public class CountingSortI {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int[] cArr = new int[100];
    	
    	int N=in.nextInt();
    	for (int i=0; i<N; i++) {
    		cArr[in.nextInt()]++;
    	}
    	in.close();
    	
    	printArray(cArr);
    }
    
    private static void printArray(int[] arr) {
		StringBuilder sb = new StringBuilder();
    	for (int elem : arr) {
    		if (sb.length()>0) sb.append(" ");
    		sb.append(elem);
    	}
		System.out.println(sb.toString());
    }
}
