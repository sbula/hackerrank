package practice.mathematics.numberTheory;

import java.util.Scanner;

public class SherlockAndGCD {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int tstCase=0; tstCase<T; tstCase++) {
			int N = in.nextInt();
			int[] array = new int[N];
			for (int ind=0; ind<N; ind++) {
				array[ind] = in.nextInt();
			}
			boolean found = false;
			int a = array[0];
			for (int ind=1; ind<N; ind++) {
				a = gcd(a, array[ind]);
				if (a == 1) {
					found = true;
					break;
				}
			}

			System.out.println(found ? "YES" : "NO");
		}
		in.close();
	}

	private static int gcd(int a, int b) {
		while (b>0) {
			int t=b;
			b = a%b;
			a = t;
		}
		return a;
	}
}