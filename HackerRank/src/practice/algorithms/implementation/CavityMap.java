package algorithms.implementation;

import java.util.Scanner;

public class CavityMap {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for (int i=0; i<n; i++) {
        	String line = in.next();
        	for (int k=0; k<n; k++) {
        		matrix[i][k] = line.charAt(k)-'0';
        	}
        }
        in.close();
        
        if (n==1) {
        	System.out.println(matrix[0][0]);
        	return;
        }

        for (int i=0; i<n; i++) {
        	StringBuilder sb = new StringBuilder(Integer.toString(matrix[i][0]));
        	for (int k=1; k<n-1; k++) {
        		int me = matrix[i][k];
        		boolean isCavity = i>0 && i<n-1 && me>matrix[i-1][k] && me>matrix[i+1][k] && me>matrix[i][k-1] && me>matrix[i][k+1];
        		sb.append(isCavity ? "X" : me);
        	}
        	sb.append(matrix[i][n-1]);
        	
        	System.out.println(sb.toString());
        }
    }
}
