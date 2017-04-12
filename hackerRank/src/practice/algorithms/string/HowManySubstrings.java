package practice.algorithms.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HowManySubstrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        String s = in.next();
        
        for(int a0 = 0; a0 < q; a0++){
            int left = in.nextInt();
            int right = in.nextInt();
            
            Set<String> subStringSet = new HashSet<String>();
            for (int i=left; i<=right; i++) {
            	for (int k=1; k+i<=right+1; k++) {
            		String substr = s.substring(i, i+k);
            		if (!subStringSet.contains(substr)) {
            			subStringSet.add(substr);
            		}
            	}
            }
            System.out.println(subStringSet.size());
        }
        in.close();
    }
}
