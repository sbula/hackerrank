package practice.algorithms.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringConstruction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int nbr = in.nextInt();
        for(int i=0; i<nbr; i++){
        	Set<Character> subStrMap = new HashSet<Character>();
            String s = in.next();
            int cost = 0;
            for (int n=0; n<s.length(); n++) {
            	Character chr = s.charAt(n);
            	if (!subStrMap.contains(chr)) {
            		subStrMap.add(chr);
            		cost++;
            	}
            }
            System.out.println(cost);
        }
        in.close();
    }
}
