package com.company;
import java.util.*;
public class PrimeGenerator {
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>=1)
        {
            t--;
            int start=sc.nextInt();
            int end=sc.nextInt();
            for(int i=start;i<=end;i++)
            {
                if(isPrime(i))System.out.println(i);
            }
        }
        System.out.println();

    }

    public static boolean isPrime(int n)
    {
        int sqrt=(int)Math.sqrt(n);
        if(n==2) return true;
        if(n==1||n%2==0) return false;
        for(int i=3;i<=sqrt;i++)
        {
            if(n%i==0) return false;
        }
        return true;

    }
}
