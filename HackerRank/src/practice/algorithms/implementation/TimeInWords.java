package algorithms.implementation;

import java.util.Scanner;

public class TimeInWords {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int h = in.nextInt();
    	int m = in.nextInt();
    	in.close();
    	
    	if (m == 0) {
    		System.out.println(numberToString(h) + " o' clock");
    		
    	} else {
    		String midTerm = (m%15==0) ? " " : (m==1) ? " minute " : " minutes ";
        	if (m<=30) {
        		System.out.println(numberToString(m) + midTerm + "past " + numberToString(h));
        		
        	} else {
        		System.out.println(numberToString(60-m) +  midTerm + "to " + numberToString(h+1));
        	}
    	}
    }
    
    private static String numberToString(int i) {
    	String myString = "";
    	switch(i) {
    	case 1 : myString = "one"; break;
    	case 2 : myString = "two"; break;
    	case 3 : myString = "three"; break;
    	case 4 : myString = "four"; break;
    	case 5 : myString = "five"; break;
    	case 6 : myString = "six"; break;
    	case 7 : myString = "seven"; break;
    	case 8 : myString = "eight"; break;
    	case 9 : myString = "nine"; break;
    	case 10 : myString = "ten"; break;
    	case 11 : myString = "eleven"; break;
    	case 12 : myString = "twelve"; break;
    	case 13 : myString = "thirteen"; break;
    	case 14 : myString = "fourteen"; break;
    	case 15 : myString = "quarter"; break;
    	case 16 : myString = "sixteen"; break;
    	case 17 : myString = "seventeen"; break;
    	case 18 : myString = "eightteen"; break;
    	case 19 : myString = "nineteen"; break;
    	case 20 : myString = "twenty"; break;
    	case 21 : myString = "twenty one"; break;
    	case 22 : myString = "twenty two"; break;
    	case 23 : myString = "twenty three"; break;
    	case 24 : myString = "twenty four"; break;
    	case 25 : myString = "twenty five"; break;
    	case 26 : myString = "twenty six"; break;
    	case 27 : myString = "twenty seven"; break;
    	case 28 : myString = "twenty eight"; break;
    	case 29 : myString = "twenty nine"; break;
    	case 30 : myString = "half"; break;
    
    	}
    	return myString;
    }
    
}
