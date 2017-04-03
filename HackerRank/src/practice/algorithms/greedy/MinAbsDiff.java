package practice.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinAbsDiff {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int nbr = in.nextInt();
        int[] input = new int[nbr];
        for (int i=0; i<nbr; i++) {
        	input[i] = in.nextInt();
        }
        in.close();
        
        Arrays.sort(input);
        
        int minDiff = Integer.MAX_VALUE;
        for (int i=1; i<input.length; i++) {
        	int diff = Math.abs(input[i] - input[i-1]);
        	if (diff<minDiff) minDiff = diff;
        }
        
        System.out.println(minDiff);
    }
    
}
