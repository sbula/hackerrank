package practice.algorithms.string;

import java.util.Scanner;

public class CamelCase {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        
        String[] r = s.split("(?=\\p{Upper})");
        System.out.println(r.length);
	}
}
