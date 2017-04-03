package practice.algorithms.string;

import java.util.Scanner;

public class PalindromeIndex {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int N = in.nextInt();
    	for (int i=0; i<N; i++) {
    		String s = in.next();
    		int k=0;
    		// find a char that is not in a palindromic order
    		while (s.charAt(k) == s.charAt(s.length()-1-k) && k<s.length()/2) {
    			k++;
    		}
    		
    		if (k>=s.length()/2) {
    			System.out.println(-1);
    			continue;
    		}
    		
    		// virtually remove the first letter and continue
    		int k1 = k;
    		while (s.charAt(k1+1) == s.charAt(s.length()-1-k1) && k1<(s.length()-1)/2) {
    			k1++;
    		}
    		
    		if (k1>=(s.length()-1)/2) {
    			System.out.println(k);
    			continue;
    		}
    		
    		// virtually remove the second letter and continue
    		k1 = k;
    		while (s.charAt(k1) == s.charAt(s.length()-2-k1) && k1<(s.length()-1)/2) {
    			k1++;
    		}
    		
    		if (k1>=(s.length()-1)/2) {
    			System.out.println(s.length()-1-k);
    			continue;
    		}
    		

			System.out.println(-1);
    	}
    	
    	in.close();
    }

}
