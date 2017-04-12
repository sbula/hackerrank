package practice.mathematics.fundamentals;

import java.util.Scanner;

public class LeonardosPrimeFactors {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T; i++) {
            long nbr = in.nextLong();
        	long[] prims = new  long[(int)Math.ceil(Math.log(nbr))];
        	int counter = 0;
        	if (nbr>1) {
        		long prod = 2;
        		prims[counter++] = 2;
        		long mult = 3;
        		long tmpProd = prod * mult;
        		while (tmpProd>0 && tmpProd <= nbr) {
        			if (!isProductOf(mult, prims)) {
        				prims[counter++] = mult;
        				prod = tmpProd;
        			}
        			mult += 2;
            		tmpProd = prod * mult;
        		}
        	}
            System.out.println(counter);
        }
        in.close();
    }
	
	private static boolean isProductOf(long prod, long[] list) {
		for (long p : list) {
			if (p!=0 && prod%p==0) return true;
		}
		return false;
	}

}
