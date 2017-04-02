package dataStructures.stacks;

import java.util.Scanner;
import java.util.Stack;

public class MaxElement {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	Stack<Integer> stack = new Stack<Integer>();
    	Stack<Integer> max = new Stack<Integer>();
    	int N = in.nextInt();
    	for (int i=0; i<N; i++) {
    		int type = in.nextInt();
    		switch (type) {
    		case 1 :
    			int pushNbr = in.nextInt();
    			stack.push(pushNbr);
    			if (max.isEmpty() || max.peek() < pushNbr) max.push(pushNbr);
    			break;
    		case 2 :
    			int popNbr = stack.pop();
    			if (!max.isEmpty() && max.peek() == popNbr) max.pop();
    			break;
    		case 3 :
                int myMax = (max.isEmpty()) ? 0 : max.peek();
    			System.out.println(myMax);
    			break;
    		}
    	}
    	
    	in.close();
    }
}
