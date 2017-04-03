package practice.algorithms.string;

import java.util.Scanner;

public class TwoCharacters {
	private static final int CHAR_NUM = 26;
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        in.close();
        
        if (len<2) {
            System.out.println(0);
        	return;
        }
        
        int[][] count = new int[CHAR_NUM][CHAR_NUM];
        int[][] pair  = new int[CHAR_NUM][CHAR_NUM];
        
        for (int i=0; i<len; i++) {
        	int myChar = (int)s.charAt(i);
        	int charPos = myChar - 'a';
        	
        	for(int k=0; k<CHAR_NUM; k++) {
        		// update rows
        		if (count[k][charPos] != -1) {
        			if (pair[k][charPos] == myChar) {
        				count[k][charPos] = -1;
        			} else {
        				pair[k][charPos] = myChar;
        				count[k][charPos]++;
        			}
        		}
        		// update columns
        		if (count[charPos][k] != -1) {
        			if (pair[charPos][k] == myChar) {
        				count[charPos][k] = -1;
        			} else {
        				pair[charPos][k] = myChar;
        				count[charPos][k]++;
        			}
        		}
        	}
        }
        
        //get the max
        int max = 0;
        for (int i=0; i<CHAR_NUM; i++) {
        	for (int k=0; k<CHAR_NUM; k++) {
        		max = (max < count[i][k]) ? count[i][k] : max;
        	}
        }
        
        System.out.println(max);
    }
}
