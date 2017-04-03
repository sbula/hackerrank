package practice.algorithms.bitManipulation;

import java.util.Scanner;

public class MaximizingXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int L = in.nextInt();
		int R = in.nextInt();
		in.close();

		int max = 0;
		for (int i=L; i<=R; i++) {
			for (int k=i; k<=R; k++) {
				int tmp = i^k;
				max = (max<tmp) ? tmp : max;
			}
		}
		
		System.out.println(max);
	}
}
