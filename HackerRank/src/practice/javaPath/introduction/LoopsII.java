package practice.javaPath.introduction;

import java.util.Scanner;

public class LoopsII {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            int nbr = b;
            int prntNbr = a + nbr;
            StringBuilder sb = new StringBuilder(Integer.toString(prntNbr));
            for (int k=1; k<n; k++) {
            	nbr *= 2;
                prntNbr += nbr;
            	sb.append(" " + prntNbr);
            }
            
            System.out.println(sb.toString());
        }
        in.close();
    }
}
