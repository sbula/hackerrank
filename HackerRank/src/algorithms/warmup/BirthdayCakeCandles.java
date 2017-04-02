package algorithms.warmup;

import java.util.Scanner;

public class BirthdayCakeCandles {

	public static void main(String[] args) {
		int maxHeight = 0;
		int blowCounter = 0;

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		for (int i=0; i<n; i++) {
			int h = in.nextInt();
			if (h>maxHeight) {
				maxHeight = h;
				blowCounter = 1;
			} else if (h==maxHeight) {
				blowCounter++;
			}
		}
		
		in.close();
		System.out.println(blowCounter);;
	}
}
