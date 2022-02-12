package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Weird_Ordering
{
    public static ArrayList<Long> order(ArrayList<Long> arr, int i)
    {
        //System.out.println(arr.size());
        arr.trimToSize();
       // System.out.println(arr.size());
        if(arr.size()<=2)
        {
            System.out.println("Returning = "+arr);
            return arr;
        }
        ArrayList<Long> l=new ArrayList();
        ArrayList<Long> r=new ArrayList();
        long n=arr.size()-1;
        for(int j=0;j<=n;j++)
        {
            if(arr.get(j)%Math.pow(2,i+1) < Math.pow(2,i))
            {
                l.add(arr.get(j));
            }
            else
            {
                //System.out.println("In loop");
                r.add(arr.get(j));
            }
        }
       System.out.println("l ="+l);
        System.out.println("r ="+r);
        l=new ArrayList<>(order(l,i+1));
        r=new ArrayList<>(order(r,i+i));
        ArrayList<Long> c=concatenate(l,r);
        System.out.println("c ="+c);
        return c;
    }

    public static ArrayList<Long> concatenate(ArrayList<Long> l,ArrayList<Long> r)
    {
        ArrayList<Long> ans=new ArrayList();
        ans.addAll(l);
        ans.addAll(r);
        System.out.println(ans);
        return ans;
    }

    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>=1)
        {
            t--;
            long p=(long)Math.pow(2,sc.nextInt())-1;
            int index=sc.nextInt();
            ArrayList<Long> arr=new ArrayList();
            for(long i=0;i<=p;i++)
            {
                arr.add(i);
            }
            arr=order(arr,0);

            //System.out.println(arr.get(index));




        }

    }


}
