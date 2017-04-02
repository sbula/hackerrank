package dataStructures.arrays;

import java.util.Scanner;

public class SparseArrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] inString= new String[in.nextInt()];
        for (int i=0; i<inString.length; i++) {
            inString[i] = in.next();
        }
        int x = in.nextInt();
        
        for (int i=0; i<x; i++) {
            String query = in.next();
            int counter =0;
            for (String s : inString) {
                if (query.equals(s)) {
                    counter++;
                }
            }
            System.out.println(counter);
        }
        
        in.close();
    }
}
