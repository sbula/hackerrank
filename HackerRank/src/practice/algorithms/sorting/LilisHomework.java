package practice.algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class LilisHomework {
	private static class Linker {
		final int value;
		final int origIndex;
		int sortAsc;
		int sortDesc;
		public Linker(int value, int origIndex) {
			this.value = value;
			this.origIndex = origIndex;
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		Linker[] origArr = new Linker[N];
		for(int i=0; i<N; i++){
			origArr[i] = new Linker(in.nextInt(), i); 
		}
		in.close();

		// sort ascending and fill in corresponding numbers
		Arrays.sort(origArr, (s1, s2) -> Integer.compare(s1.value, s2.value));
		for (int i=0; i<N; i++) {
			origArr[i].sortAsc = i;
			origArr[i].sortDesc = N-i-1;
		}
		
		// rearrange to original input order
		Arrays.sort(origArr, (s1, s2) -> Integer.compare(s1.origIndex, s2.origIndex));
		
		// find loops and count the swaps
		int swapAsc = 0;
		for (int i=0; i<N; i++) {
			if (origArr[i].sortAsc == -1 || (origArr[i].sortAsc == origArr[i].origIndex)) {
				continue;
			}
			
			int index = i;
			while (origArr[index].sortAsc != -1) {
				int nextInd = origArr[index].sortAsc;
				origArr[index].sortAsc = -1;
				index = nextInd;
				swapAsc++;
			}
			swapAsc--; // deduct one per cycle...
		}
		
		// find loops and count the swaps
		int swapDesc = 0;
		for (int i=0; i<N; i++) {
			if (origArr[i].sortDesc == -1 || (origArr[i].sortDesc == origArr[i].origIndex)) {
				continue;
			}
			
			int index = i;
			while (origArr[index].sortDesc != -1) {
				int nextInd = origArr[index].sortDesc;
				origArr[index].sortDesc = -1;
				index = nextInd;
				swapDesc++;
			}
			swapDesc--; // deduct one per cycle...
		}
		
		System.out.println(Math.min(swapAsc, swapDesc));
	}
}
