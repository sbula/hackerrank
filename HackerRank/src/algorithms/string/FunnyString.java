package algorithms.string;

import java.util.Scanner;

public class FunnyString {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int N = in.nextInt();
    	String[] inStrings = new String[N];
    	for (int i=0; i<N; i++) {
    		inStrings[i] = in.next();
    	}
    	in.close();
    	

    	for (int i=0; i<N; i++) {
    		int len = inStrings[i].length();
    		int halfLen = len / 2 + 1;
    		
    		if (len<2) {
        		System.out.println(("Not Funny"));
    			break;
    		}
    		
    		boolean isFunny = true;
    		for (int k=1; k<halfLen; k++) {
    			int a = Math.abs(inStrings[i].charAt(k) - inStrings[i].charAt(k-1));
    			int b = Math.abs(inStrings[i].charAt(len-k) - inStrings[i].charAt(len-1-k));
    			if (a != b) {
    				isFunny = false;
    				break;
    			}
    		}
    		System.out.println((isFunny ? "Funny" :  "Not Funny"));
    	}
    }
}
