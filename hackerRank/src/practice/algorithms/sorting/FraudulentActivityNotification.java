package practice.algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class FraudulentActivityNotification {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int days = in.nextInt();
		int[] spendArray = new int[N];
		for(int i=0; i<N; i++){
			spendArray[i] = in.nextInt();
		}
		in.close();
		

		int[] tmpArray = new int[days];
		for(int i=0; i<days; i++) {
			tmpArray[i] = spendArray[i];
		}
		
		Arrays.sort(tmpArray);
		int fraudulentCounter = 0;
		for(int i=0; i+days<N; i++) {
			int meanX2 = (days%2==0) ? tmpArray[days/2-1] + tmpArray[days/2] : tmpArray[days/2]*2;
			if (meanX2<=spendArray[days+i]) {
				fraudulentCounter++;
			}
			replace(tmpArray, spendArray[i], spendArray[i+days]);
		}
		
		System.out.println(fraudulentCounter);
	}

	private static void replace(int[] tmpArray, int rem, int ins) {
		if (rem == ins) return;
		if (rem < ins) {
			int i=0;
			while (tmpArray[i] <= rem) {
				i++;
			}
			i--;
			while (i<tmpArray.length-1 && tmpArray[i] < ins) {
				tmpArray[i] = tmpArray[++i];
			}
			tmpArray[i] = ins;
		} else {
			int i=tmpArray.length-1;
			while (tmpArray[i] >= rem) {
				i--;
			}
			i++;
			while (0<i && tmpArray[i] > ins) {
				tmpArray[i] = tmpArray[--i];
			}
			tmpArray[i] = ins;
		}
	}

}
