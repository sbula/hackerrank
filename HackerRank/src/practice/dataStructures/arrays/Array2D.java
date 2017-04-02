package dataStructures.arrays;

import java.util.Scanner;

public class Array2D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] inMat = new int[6][6];
        for (int i=0; i<6; i++) {
            for (int k=0; k<6; k++) {
                inMat[i][k] = in.nextInt();
            }
        }
        in.close();
        
        int max = Integer.MIN_VALUE;
        for (int i=0; i<4; i++) {
            for (int k=0; k<4; k++) {
                int tmp = inMat[i][k] + inMat[i][k+1] + inMat[i][k+2] + inMat[i+1][k+1] + inMat[i+2][k] + inMat[i+2][k+1] + inMat[i+2][k+2];
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        System.out.print(max);
    }
}
