package algorithms.warmup;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinus {
    private static DecimalFormat df6 = new DecimalFormat(".######");
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int posCount = 0, zeroCount = 0, negCount = 0;
        for (int i=0; i<N; i++) {
            int tmp = in.nextInt();
            if (tmp>0) {
            	posCount++;
            } else if (tmp==0) {
            	zeroCount++;
            } else {
            	negCount++;
            }
        }
        in.close();

        System.out.println(df6.format(posCount/(double)N));
        System.out.println(df6.format(negCount/(double)N));
        System.out.println(df6.format(zeroCount/(double)N));
    }
}
