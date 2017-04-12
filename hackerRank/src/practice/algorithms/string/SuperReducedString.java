package practice.algorithms.string;

import java.util.Scanner;

public class SuperReducedString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(in.next());
		in.close();
		
		int i=0;
		while (i+1 < sb.length()) {
			if (sb.charAt(i) == sb.charAt(i + 1)) {
				sb = sb.delete(i, i + 2);
				i = 0;
			} else {
				i++;
			}
		}

		System.out.println((sb.length() == 0) ? "Empty String" : sb.toString());
	}
}
