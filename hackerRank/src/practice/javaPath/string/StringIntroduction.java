package practice.javaPath.string;

import java.util.Scanner;

public class StringIntroduction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String A = in.next();
        String B = in.next();
        in.close();

        String A1 = A.substring(0, 1).toUpperCase() + A.substring(1);
        String B1 = B.substring(0, 1).toUpperCase() + B.substring(1);
        
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B)>0 ? "Yes" : "No");
        System.out.println(A1 + " " + B1);
    }
}
