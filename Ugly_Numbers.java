package com.company;

import java.util.Scanner;

public class Ugly_Numbers {
    public static void main(String[] args)
    {
        int n=new Scanner(System.in).nextInt();
        if(n<7) System.out.println(n);
        else {
            int count=6;
            int i = 7,ans=0;
            for (; count <n; i++) {
                ans=i;
                i=numex(i, 2);
                i=numex(i, 3);
                i=numex(i, 5);
                if(i==1) count++;
                i=ans;
            }
            System.out.println(ans);
        }

    }
    public static int numex(int n,int div)
    {
        while(n%div==0) n/=div;
        return n;
    }
}
