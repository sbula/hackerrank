package practice.algorithms.implementation;

import java.util.Scanner;

public class GradingStudents {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	for (int i=0; i<n; i++) {
    		int grade = in.nextInt();
    		if (grade >= 38 && grade%5 >2) grade = (grade/5+1)*5;
    		System.out.println(grade);
    	}
    	in.close();
    }
}
