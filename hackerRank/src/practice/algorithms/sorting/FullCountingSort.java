package practice.algorithms.sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FullCountingSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N=in.nextInt();
		
		Map<Integer, List<Integer>> intListMap =  new HashMap<Integer, List<Integer>>();
		String[] input = new String[N];
		for (int i=0; i<N; i++) {
			int code = in.nextInt();
			if (!intListMap.containsKey(code)) intListMap.put(code, new ArrayList<Integer>());
			intListMap.get(code).add(i);
			input[i] = in.next();
		}
		in.close();
		
		// overwrite first half of the input
		for (int i=0; i<N/2; i++) {
			input[i] = "-";
		}
		
		print(intListMap, input);
	}

	private static void print(Map<Integer, List<Integer>> intListMap, String[] input) {
		StringBuilder sb = new StringBuilder();
		for (Integer key : intListMap.keySet()) {
			for (int index :intListMap.get(key)) {
	    		if (sb.length()>0) sb.append(" ");
	    		sb.append(input[index]);
			}
		}
		System.out.println(sb.toString());
	}
}
