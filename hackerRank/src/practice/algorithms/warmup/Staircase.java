package practice.algorithms.warmup;

import java.util.Scanner;

public class Staircase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.close();
        
        for (int i=1; i<=N; i++) {
            for (int k=0; k<N-i; k++) {
                System.out.print(" ");
            }
            for (int k=N-i; k<N; k++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
