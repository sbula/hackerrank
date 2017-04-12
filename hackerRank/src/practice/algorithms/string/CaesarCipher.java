package practice.algorithms.string;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	String str = in.next();
    	int k = in.nextInt();
    	in.close();
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i=0; i<n; i++) {
    		char c = str.charAt(i);
    		if ('a'<=c && c<='z') {
    			sb.append((char)((c-'a'+k)%('z'-'a')+'a'));
    		} else if ('A'<=c && c<='Z') {
    			sb.append((char)((c-'A'+k)%('Z'-'A')+'A'));
    		} else {
    			sb.append(c);
    		}
    	}
    	System.out.println(sb.toString());
    }
}
