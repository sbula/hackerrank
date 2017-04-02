package algorithms.bitManipulation;

import java.util.Scanner;

public class LonelyInteger {
     private static int lonelyInteger(int[] a) {
    	 int res = a[0];
    	 for (int i=1; i<a.length; i++) {
    		 res = res^a[i];
    	 }
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        in.close();
        System.out.println(lonelyInteger(a));
    }
}
