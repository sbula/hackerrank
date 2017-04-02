package practice.algorithms.warmup;

import java.util.Scanner;

public class CompareTriplets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[3];
        for (int i=0; i<3; i++) {
        	a[i] = in.nextInt();
        }
        
        int[] b = new int[3];
        for (int i=0; i<3; i++) {
        	b[i] = in.nextInt();
        }
        in.close();
        
        int wonAlice = 0;
        int wonBob = 0;

        for (int i=0; i<3; i++) {
        	if (a[i] < b[i]) wonBob++; 
        	if (a[i] > b[i]) wonAlice++; 
        }
        
        System.out.println(wonAlice + " " + wonBob);
    }
}