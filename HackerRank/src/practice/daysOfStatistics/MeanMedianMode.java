package practice.daysOfStatistics;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class MeanMedianMode {
    private static DecimalFormat df2 = new DecimalFormat(".#");
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] input = new int[N];
        for (int i=0; i<N; i++) {
            input[i] = in.nextInt();
        }
        in.close();
        
        Arrays.sort(input);
        int sum = 0;
        int maxMode = -1;
        int tmpMode = 0;
        int modeNumber = -1;
        int prevModeNbr = -1;
        for (int i=0; i<N; i++) {
            sum += input[i];
            if (input[i] == prevModeNbr) {
                tmpMode++;
            } else {
            //    System.out.println("DEBUG: mode = " + tmpMode + "; number = " + prevModeNbr);
                if (maxMode < tmpMode) {
                    maxMode =  tmpMode;
                    modeNumber = prevModeNbr;
                }
                prevModeNbr = input[i];
                tmpMode = 1;
            }
        }
        
        double mean = ((double)sum)/((double)N);
        double median = (N%2==0) ? (input[N/2] + input[N/2-1])/2d : input[N/2];
        
        System.out.println(df2.format(mean));
        System.out.println(df2.format(median));
        System.out.println(modeNumber);
    }
}
