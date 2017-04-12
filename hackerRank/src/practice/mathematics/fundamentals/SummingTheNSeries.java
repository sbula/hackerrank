package practice.mathematics.fundamentals;

import java.util.Scanner;

public class SummingTheNSeries {
	private static final long mod = 1000000007;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int T = in.nextInt();
		for (int i=0; i<T; i++) {
			// T = n*n - (n-1)*(n-1) = 2*n-1
			// ==> sum (T) = sum (2*n-1) = 2*sum(n)-t
			// ==> = 2*(N*(N+1)/2)-N = N*N+N - N = N*N
			long N = in.nextLong()%mod;
			long res = (N*N)%mod;
			System.out.println(res);
		}
		in.close();
	}
}
