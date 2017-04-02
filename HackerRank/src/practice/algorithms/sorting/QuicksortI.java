package algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuicksortI {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int N=in.nextInt();
    	int[] ar = new int[N];
    	for (int i=0; i<N; i++) {
    		ar[i] = in.nextInt();
    	}
    	in.close();

    	List<Integer> left = new ArrayList<Integer>();
    	List<Integer> equal = new ArrayList<Integer>();
    	List<Integer> right = new ArrayList<Integer>();
    	int pivot = ar[0];
    	equal.add(pivot);
    	for (int i=1; i<N; i++) {
    		if (ar[i]<pivot) left.add(ar[i]);
    		else if (ar[i]>pivot) right.add(ar[i]);
    		else equal.add(ar[i]);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	appendToString(sb, left);
    	appendToString(sb, equal);
    	appendToString(sb, right);
    	
    	System.out.println(sb.toString());
    }
    
    private static void appendToString(StringBuilder sb, List<Integer> list) {
    	for (int elem : list) {
    		if (sb.length()>0) sb.append(" ");
    		sb.append(elem);
    	}
    }
}
