package mathematics.fundamentals;

import java.util.Scanner;

public class FindThePoint {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        for (int i=0; i<a; i++) {
            int p1 = in.nextInt();
            int p2 = in.nextInt();
            int q1 = in.nextInt();
            int q2 = in.nextInt();
            
            System.out.println((2*q1 - p1) + " " + (2*q2 - p2));
        }
        in.close();
    }
}
