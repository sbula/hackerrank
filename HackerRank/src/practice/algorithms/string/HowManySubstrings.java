package practice.algorithms.string;

import java.util.Scanner;

public class HowManySubstrings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        String s = in.next();
        
        // gather information of differences
        int[][] substrigs = new int [n][n];
        for (int i=0; i<n; i++) {
        	substrigs[0][i] = s.charAt(i) -'a'+1;
        }
        for (int k=1; k<n; k++) {
        	for (int i=0; i<n-k; i++) {
        		substrigs[k][i] = substrigs[k-1][i] * 26 + substrigs[k-1][i+1];
        	}
        }
        
        
        for(int a0 = 0; a0 < q; a0++){
            int left = in.nextInt();
            int right = in.nextInt();
            // your code goes here
        }
        in.close();
    }

}
