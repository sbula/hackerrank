package algorithms.sorting;

import java.util.Scanner;

public class InsertionSortII {
	
    public static void insertionSortPart2(int[] ar) {
        int counter = 0;
    	for (int i=1; i<ar.length; i++) {
    		int ind = i;
    		int ins = ar[ind--];
            while (ind>=0 && ar[ind]>ins) {
            	ar[ind+1] = ar[ind--];
            }
            ar[ind+1] = ins;
    		counter++;
    	}
        
        System.out.println(counter);
    }  
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    
}
