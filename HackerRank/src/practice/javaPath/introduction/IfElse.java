package javaPath.introduction;

import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        StringBuilder sb = new StringBuilder();
        if (n%2==0 && ((2<=n && n<=5) || 20<n)) {
        	sb.append("Not ");
        }
        
          sb.append("Weird");
        System.out.println(sb.toString());
    }
}
