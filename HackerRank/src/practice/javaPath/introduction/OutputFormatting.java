package javaPath.introduction;

import java.util.Scanner;

public class OutputFormatting {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("================================");
		for(int i=0;i<3;i++){
			String s1=sc.next();
			int x=sc.nextInt();
			System.out.println(String.format("%1$-14s %2$03d", s1, x));
		}
		System.out.println("================================");
		sc.close();
	}

}
