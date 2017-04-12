package practice.mathematics.fundamentals;

import java.util.Scanner;

public class MaximumDraws {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		for (int i=0; i<N; i++) {
			System.out.println(in.nextInt() + 1);
		}
		in.close();
	}
}
