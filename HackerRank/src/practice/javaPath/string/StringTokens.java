package javaPath.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokens {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        in.close();
        
        StringTokenizer defTokenizer = new StringTokenizer(s, "[ !,?._'@]");
        System.out.println(defTokenizer.countTokens());
        while(defTokenizer.hasMoreTokens()) {
        	System.out.println(defTokenizer.nextToken());
        }
    }
}
