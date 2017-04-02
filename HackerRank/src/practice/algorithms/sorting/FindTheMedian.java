package practice.algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheMedian {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N=in.nextInt();
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = in.nextInt();
		}
		in.close();
		
		Arrays.sort(arr);
		System.out.println(arr[arr.length/2]);
	}

}
