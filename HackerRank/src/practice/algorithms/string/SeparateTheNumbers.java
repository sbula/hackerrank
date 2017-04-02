package algorithms.string;

import java.util.Scanner;

public class SeparateTheNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for(int i=0; i<N; i++){
            String s = in.next();
            
            long startNumber = -1;
            for (int len = 1; len<=(s.length()+1)/2; len++) {
            	long startNbr = getFirstNumber(s, len);
            	if (checkString(s, startNbr)) {
            		startNumber = startNbr;
            		break;
            	}
            }
            
            if (startNumber > -1) {
            	System.out.println("YES " + startNumber);
            } else {
            	System.out.println("NO");
            }
        }
        in.close();
    }
    
    
    private static boolean checkString(String s, long startNbr) {
    	if (s.length() == 0) return true;
    	String nbrString = Long.toString(startNbr);
    	if (s.length() < nbrString.length()) return false;
    	if (!s.startsWith(nbrString)) return false;
    	
    	String newCheck = s.substring(nbrString.length());
    	return checkString(newCheck, ++startNbr);
    }
    
    private static long getFirstNumber(String s, int len) {
    	if (len>=(s.length()+2)/2) {
        	return -1;
    	}
    	String sub = s.substring(0, len);
    	return Long.parseLong(sub);
    }
}
