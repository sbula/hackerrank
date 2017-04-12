package practice.algorithms.string;

import java.util.Scanner;

public class MarsExploration {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String S = in.next();
		in.close();
		
		int counter=0;
		for (int i=0; i<S.length(); i++) {
			if (S.charAt(i) != "SOS".charAt(i%3)) {
				counter++;
			}
		}
		System.out.println(counter);
	}
}
