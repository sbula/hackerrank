package algorithms.implementation;

import java.util.Scanner;

public class Encryption {
	 public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 String input = in.nextLine().trim();
		 int len = input.length();
		 in.close();
		 
		 double sqrtLen = Math.sqrt(len);
		 int rows = (int)Math.floor(sqrtLen); 
		 int column = (int)Math.ceil(sqrtLen);
		 if (rows * column < sqrtLen) rows++;
		 
		 StringBuilder[] resultBuilder = new StringBuilder[column];
		 for (int i=0; i<column; i++) {
			 resultBuilder[i] = new StringBuilder();
		 }
		 
		 int k = 0;
		 while (k < len) {
			 resultBuilder[k%column].append(input.charAt(k));
			 k++;
		 }
		 
		 for (int i=0; i<column; i++) {
			 System.out.print(resultBuilder[i].toString() + " ");
		 }
	 }
}
