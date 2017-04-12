package practice.mathematics.fundamentals;

import java.util.Scanner;

public class Handshake {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int N = in.nextInt();
            System.out.println((N*(N-1)/2));
        }
        in.close();
    }

}
