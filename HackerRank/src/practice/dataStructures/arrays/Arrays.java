package practice.dataStructures.arrays;

import java.util.Scanner;

public class Arrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int A[] = new int[in.nextInt()];
        
        for(int i=0; i<A.length; i++) {
            A[i] = in.nextInt();
        }
        in.close();
        
        StringBuilder sb = new StringBuilder();
        for(int i=A.length-1; i>=0; i--) {
            sb.append(A[i]+" ");
        }
        System.out.print(sb.toString());
    }
}
