package algorithms.sorting;

import java.util.Scanner;

public class InsertionSortI {

    public static void insertIntoSorted(int[] ar) {
        int i = ar.length-1;
        int ins = ar[i--];
        while (i>=0 && ar[i]>ins) {
        	ar[i+1] = ar[i--];
        	printArray(ar);
        }
        ar[i+1] = ins;
    	printArray(ar);
    }
    
    
/* Tail starts here */
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
         for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
         }
         insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
    
    
}
