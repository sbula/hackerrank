package javaPath.string;

import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String A=in.next();
		in.close();
		
		for (int i=0; i<(A.length()+1)/2; i++) {
			if (A.charAt(i) != A.charAt(A.length()-1-i)) {
				System.out.println("No");
				return;
			}
		}
		System.out.println("Yes");
	}
}
