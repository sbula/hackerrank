package javaPath.introduction;

import java.util.Scanner;

public class StdinStdoutI {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int a = in.nextInt();
    	int b = in.nextInt();
    	int c = in.nextInt();
    	in.close();

    	System.out.println(a);
    	System.out.println(b);
    	System.out.println(c);
    }
}
