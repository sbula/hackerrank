package practice.javaPath.string;

import java.util.Scanner;

public class StringCompare {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	String str = in.nextLine();
    	int len = in.nextInt();
    	in.close();
    	
    	String shortest = null;
    	String largest = null;
    	int offSet = 0;
    	while (offSet + len <= str.length()) {
    		String subStr = str.substring(offSet,  offSet+len);
    		shortest = (shortest != null && shortest.compareTo(subStr) < 0) ? shortest : subStr;
    		largest = (largest != null && largest.compareTo(subStr) > 0) ? largest : subStr;
    		offSet++;
    	}
    	System.out.println(shortest);
    	System.out.println(largest);
    }
}
