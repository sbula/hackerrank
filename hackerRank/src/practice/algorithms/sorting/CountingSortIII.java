package practice.algorithms.sorting;

import java.util.Scanner;

public class CountingSortIII {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] cArr = new int[100];

		int N=in.nextInt();
		for (int i=0; i<N; i++) {
			cArr[in.nextInt()]++;
			String tmp = in.next();
		}
		in.close();

		printArray(cArr);
	}
    
    private static void printArray(int[] arr) {
		StringBuilder sb = new StringBuilder();
		int offSet = 0;
    	for (int count : arr) {
    		offSet += count;
    		if (sb.length()>0) sb.append(" ");
    		sb.append(offSet);
    	}
		System.out.println(sb.toString());
    }
}
