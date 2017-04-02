package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClosestNumber {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	
    	int N=in.nextInt();
    	int[] nbrArr = new int[N];
    	for (int i=0; i<N; i++) {
    		nbrArr[i] = in.nextInt();
    	}
    	in.close();
    	
    	Arrays.sort(nbrArr);
    	
    	List<Integer> resultList = new ArrayList<Integer>();
    	int minDiff = Integer.MAX_VALUE;
    	for (int i=0; i<N-1; i++) {
    		int diff = Math.abs(nbrArr[i]-nbrArr[i+1]);
    		if (diff<minDiff) {
    			resultList.clear();
    			minDiff = diff;
    		}
    		if (diff==minDiff) {
    			resultList.add(nbrArr[i]);
    			resultList.add(nbrArr[i+1]);
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (Integer nbr : resultList) {
    		if (sb.length()>0) sb.append(" ");
    		sb.append(nbr);
    	}
    	
    	System.out.println(sb.toString());
    }
}
