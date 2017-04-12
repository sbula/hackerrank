package practice.mathematics.fundamentals;

import java.util.Scanner;

public class ConnectingTowns {
	private static final int mod = 1234567;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int T = in.nextInt();
		for (int i=0; i<T; i++) {
			long res = 1;
			int N = in.nextInt()-1;
			for (int k=0; k<N; k++) {
				res = (res * in.nextLong()) % mod;
			}
			System.out.println(res);
		}
		
		in.close();
	}
}
