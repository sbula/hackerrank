package practice.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class AlmostSorted {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] input = new int[n];
		int[] sorted = new int[n];
		for (int i=0; i<n; i++) {
			input[i] = in.nextInt();
			sorted[i] = input[i];
		}
		in.close();

		Arrays.sort(sorted);

		int iL = -1;
		int iM = -1;
		int iR = -1;
		for (int i=0; i<n; i++) {
			int diff = input[i] - sorted[i];
			if (iL>=0 && iR>=0 && diff!=0) iM = i;
			if (iL<0 && diff>0) iL = i;
			if (diff<0) iR = i;
		}

		if (iL<0) {
			System.out.println("yes");
			return;
		}

		if (iM<0) {
			if (input[iL] == sorted[iR] && input[iR] == sorted[iL]) {
				System.out.println("yes");
				System.out.println("swap " + (iL+1) + " " + (iR+1));
				return;
			}
		} 

		for (int i=0; i<iR-iL; i++) {
			int diff = input[iL+i] - sorted[iR-i];
			if (diff != 0) {
				System.out.println("no");
				return;
			}
		}

		System.out.println("yes");
		System.out.println("reverse " + (iL+1) + " " + (iR+1));
	}
}
