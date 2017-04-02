package javaPath.string;

import java.util.Arrays;

public class Anagrams {
	static boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) return false;
		int[] charArrayA = a.toUpperCase().chars().toArray();
		int[] charArrayB = b.toUpperCase().chars().toArray();

		Arrays.sort(charArrayA);
		Arrays.sort(charArrayB);
		
		for (int i=0; i<charArrayA.length; i++) {
			if (charArrayA[i] != charArrayB[i]) {
				return false;
			}
		}
		return true;
	}
}
