package practice.algorithms.sorting;

import java.util.Scanner;

public class Intro {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int val = in.nextInt();
    	int len = in.nextInt();
    	int pos = 0;
    	while (in.hasNext() && pos<len) {
    		if (val == in.nextInt()) {
    			System.out.println(pos);
    			in.close();
    			return;
    		}
    		pos++;
    	}
    	in.close();
    }
}
