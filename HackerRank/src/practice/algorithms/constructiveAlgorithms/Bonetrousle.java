package practice.algorithms.constructiveAlgorithms;

import java.util.Scanner;

public class Bonetrousle {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int trips = in.nextInt();
    	for (int i=0; i<trips; i++) {
    		long sticks = in.nextLong();
    		long stored = in.nextLong();
    		int boxes = in.nextInt();
    		
    		long[] buyList = new long[boxes];
    		long sticksToGet = sticks;
    		for(int k=0; k<buyList.length; k++) {
    			buyList[k] = k+1;
    			sticksToGet -= (k+1);
    		}
    		int xChgInd = 0;
    		long minAvailable = (long)boxes+1;
    		long maxAvailable = stored;
    		while(xChgInd<buyList.length && sticksToGet>0 && maxAvailable >= minAvailable) {
    			if (sticksToGet<maxAvailable-buyList[xChgInd]) {
    				if (minAvailable<=buyList[xChgInd]+sticksToGet) {
    					buyList[xChgInd] += sticksToGet; 
    					sticksToGet = 0;
    				} else {
    					xChgInd = buyList.length-(int)sticksToGet;
    					buyList[xChgInd] = minAvailable;
    					sticksToGet = 0;
    				}
    			} else {
    				sticksToGet -= maxAvailable-buyList[xChgInd];
    				buyList[xChgInd] = maxAvailable;
    				maxAvailable--;
    				xChgInd++;
    			}
    		}
    		
    		if (sticksToGet != 0) {
    			System.out.println(-1);
    			continue;
    		}
    		
    		StringBuilder sb = new StringBuilder(Long.toString(buyList[0]));
    		for (int n=1; n<buyList.length; n++) {
    			sb.append(" " + buyList[n]);
    		}
    		System.out.println(sb.toString());
    	}
    	in.close();
    }

}
