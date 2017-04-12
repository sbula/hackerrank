package practice.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MarcsCakewalk {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] calories = new Integer[n];
        for(int calories_i=0; calories_i < n; calories_i++){
            calories[calories_i] = in.nextInt();
        }
        in.close();
        
        Arrays.sort(calories, (i1, i2) -> Integer.signum(i2 - i1));
        long mult = 1l;
        long sum =0l;
        for (int i=0; i<n; i++) {
        	sum += mult * calories[i];
        	mult *= 2;
        }
        
        System.out.println(sum);
    }
}
