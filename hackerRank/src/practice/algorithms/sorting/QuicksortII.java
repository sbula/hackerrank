package practice.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuicksortII {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int N=in.nextInt();
        
        List<Integer> input = new ArrayList<Integer>();
    	for (int i=0; i<N; i++) {
    		input.add(in.nextInt());
    	}
    	in.close();
    }
    
    public static List<Integer> sort(List<Integer> myList) {
    	List<Integer> left = new ArrayList<Integer>();
    	List<Integer> equal = new ArrayList<Integer>();
    	List<Integer> right = new ArrayList<Integer>();
    	
    	Integer pivot = null;
    	for (Integer nbr : myList) {
    		if (pivot == null || pivot.compareTo(nbr)==0) {
    			pivot = nbr;
    			equal.add(nbr);
    		} else if (pivot.compareTo(nbr)>0) {
    			left.add(nbr);
    		} else {
    			right.add(nbr);
    		}
    	}

    	StringBuilder sb = new StringBuilder();
    	List<Integer> res = new ArrayList<Integer>();
    	if (!left.isEmpty()) {
    		left = sort(left);
    		appendToString(sb, left);
        	res.addAll(left);
    	}
    	
    	appendToString(sb, equal);
    	res.addAll(equal);
    	
    	if (!right.isEmpty()) {
    		right = sort(right);
    		appendToString(sb, right);
        	res.addAll(right);
    	}
    	
    	if(!left.isEmpty() || !right.isEmpty()) System.out.println(sb.toString());
    	
    	return res;
    }
    
    private static void appendToString(StringBuilder sb, List<Integer> list) {
    	for (int elem : list) {
    		if (sb.length()>0) sb.append(" ");
    		sb.append(elem);
    	}
    }
}
