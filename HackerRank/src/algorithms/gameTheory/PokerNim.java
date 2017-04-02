package algorithms.gameTheory;

import java.util.Scanner;

public class PokerNim {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int T = in.nextInt();
    	
    	for (int i=0; i<T; i++) {
    		int pileNbr = in.nextInt();
    		int k = in.nextInt();
    		int c = 0;
    		for (int n=0; n<pileNbr; n++) {
    			c ^= in.nextInt();
    		}
    		
    		if (c==0) {
    			System.out.println("Second");
    		} else {
    			System.out.println("First");
    		}
    		
    	}
    	in.close();
    }
}