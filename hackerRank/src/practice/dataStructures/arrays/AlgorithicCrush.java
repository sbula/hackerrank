package practice.dataStructures.arrays;

import java.util.Scanner;

public class AlgorithicCrush {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dim = in.nextInt();
        int rounds = in.nextInt();
        in.close();
        
        long[] valAr = new long[dim+1];
        for (int i=0; i<rounds; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            long k = in.nextLong();
            valAr[a] += k;
            if (b<dim) {
                valAr[b+1] -= k;
            }
        }
        
        long max = 0;
        long sum = 0;
        for (int i=0; i<valAr.length; i++) {
            sum += valAr[i];
            if (max<sum) {
                max = sum;
            }
        }
        System.out.println(max);
    }
}
