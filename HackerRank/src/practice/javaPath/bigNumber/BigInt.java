package javaPath.bigNumber;

import java.math.BigInteger;
import java.util.Scanner;

public class BigInt {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	BigInteger bigA = new BigInteger(in.nextLine());
    	BigInteger bigB = new BigInteger(in.nextLine());
    	in.close();
    	
    	BigInteger sum = bigA.add(bigB);
    	BigInteger mult = bigA.multiply(bigB);

    	System.out.println(sum);
    	System.out.println(mult);
    }
}
