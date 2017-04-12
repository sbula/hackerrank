package practice.algorithms.implementation;

import java.util.Scanner;

public class DivisibleSumPairs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();

		int a[] = new int[n];
		for(int i=0; i<n; i++){
			a[i] = in.nextInt();
		}
		in.close();
		
		int count=0;
		for(int i=0;i<a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				if((a[i]+a[j])%k==0){
					count++;
				}
			}
		}

		System.out.println(count);
	}
}
