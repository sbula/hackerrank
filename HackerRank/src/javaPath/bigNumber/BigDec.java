package javaPath.bigNumber;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class BigDec {
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();
        
        // Sort
        Arrays.sort(s, (a, b) -> {
            if (Objects.isNull(a) || Objects.isNull(b)) {
                return 0;
            }
            return new BigDecimal(b).compareTo(new BigDecimal(a));
        });
        
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
