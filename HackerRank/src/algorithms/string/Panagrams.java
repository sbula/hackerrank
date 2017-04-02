package algorithms.string;

import java.util.Scanner;

public class Panagrams {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		in.close();
		s = s.toLowerCase();

		// sum of ('a'-'a', 'b'-'a', 'c'-'a',... ,'z'-'a' + 26)
		int refSum = 325 + 26;
		boolean[] boolArray = new boolean[26];

		for (int i=0; i<s.length(); i++) {
			char testChar = s.charAt(i);
			if (testChar != ' ' && !boolArray[testChar - 'a']) {
				refSum -= (testChar - 'a' + 1);
				boolArray[testChar - 'a'] = true;
			}
		}

		if (refSum == 0) {
			System.out.println("pangram");
		} else {
			System.out.println("not pangram");
		}
	}
}
