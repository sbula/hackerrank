package practice.mathematics.fundamentals;

import java.util.Scanner;

public class ArmyGame {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.close();

        n = (int)Math.ceil((double)n/2d);
        m = (int)Math.ceil((double)m/2d);
        System.out.println(n*m);
	}

}
