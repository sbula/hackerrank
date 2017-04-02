package practice.algorithms.implementation;

import java.util.Scanner;

public class AppleAndOranges {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int houseL = in.nextInt();
        int houseR = in.nextInt();
        int appleTree = in.nextInt();
        int orangeTree = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        
        int apples = 0;
        for(int apple_i=0; apple_i < m; apple_i++) {
        	int fallingApple = appleTree + in.nextInt();
            if(houseL <= fallingApple && fallingApple <= houseR) {
            	apples++;
            }
        }

        int oranges = 0;
        for(int orange_i=0; orange_i < n; orange_i++) {
        	int fallingOranges = orangeTree + in.nextInt();
            if(houseL <= fallingOranges && fallingOranges <= houseR) {
            	oranges++;
            }
        }
        in.close();

        System.out.println(apples);
        System.out.println(oranges);
	}
}