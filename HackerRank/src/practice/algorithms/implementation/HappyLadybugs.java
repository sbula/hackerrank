package practice.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class HappyLadybugs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
            int n = in.nextInt();
            String b = in.next();
            
            char[] board = new char[n];
            boolean hasUscore = false;
            for (int i=0; i<n; i++) {
            	board[i] = b.charAt(i);
            	hasUscore = (hasUscore || board[i]=='_');
            }
            
            if (hasUscore) Arrays.sort(board);
            
            boolean happy = true;
            int k=0;
            while (happy && k<board.length) {
            	happy = board[k]=='_' || (k-1>=0 && board[k]==board[k-1]) || (k+1<board.length && board[k]==board[k+1]);
            	k++;
            }
            
            System.out.println((happy) ? "YES" : "NO");
        }
        in.close();
    }
}
