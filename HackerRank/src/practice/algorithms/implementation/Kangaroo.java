package algorithms.implementation;

import java.util.Scanner;

public class Kangaroo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int v1 = in.nextInt();
		int x2 = in.nextInt();
		int v2 = in.nextInt();
		in.close();

		if (v1<=v2) {
			System.out.println("NO");
		} else {
			String out = ((x2-x1) % (v1-v2) == 0) ? "YES" : "NO";
			System.out.println(out);
		}
	}
}
