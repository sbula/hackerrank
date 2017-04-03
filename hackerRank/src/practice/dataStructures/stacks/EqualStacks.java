package practice.dataStructures.stacks;

import java.util.Scanner;

public class EqualStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        long sum1 = 0l;
        long sum2 = 0l;
        long sum3 = 0l;
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
            sum1 += h1[h1_i];
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
            sum2 += h2[h2_i];
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
            sum3 += h3[h3_i];
        }
        in.close();

        int k1 = 0;
        int k2 = 0;
        int k3 = 0;
        while ((sum1 != sum2 || sum1 != sum3) && sum1>0 ) {
            if ((sum1 > sum2 || sum1 > sum3) && k1 < n1) {
                sum1 -= h1[k1++];
            } else if ((sum2 > sum1 || sum2 > sum3) && k2 < n2) {
                sum2 -= h2[k2++];
            } else if ((sum3 > sum1 || sum3 > sum2) && k3 < n3) {
                sum3 -= h3[k3++];
            }
        }
        
        System.out.println(sum1);
    }
}
