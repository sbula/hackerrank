package javaPath.introduction;

import java.util.Scanner;

public class EndOfFile {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int i=1;
    	while (in.hasNext()) {
    		System.out.println(i++ + " " + in.nextLine());
    	}
    	in.close();
    }
}
