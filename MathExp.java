package com.company;

import java.util.Scanner;

public class MathExp {
    public static String[] calculate(String[]arr,char ch)
    {
        String[] ans=new String[arr.length];
        int ind=0;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]==(""+ch))
            {
                switch(ch)
                {
                    case'/': ans[ind]+=(Integer.parseInt(arr[i-1])/Integer.parseInt(arr[i+11]));
                    case'*': ans[ind]+=(Integer.parseInt(arr[i-1])*Integer.parseInt(arr[i+11]));
                    case'-': ans[ind]+=(Integer.parseInt(arr[i-1])-Integer.parseInt(arr[i+11]));
                    case'+': ans[ind]+=(Integer.parseInt(arr[i-1])+Integer.parseInt(arr[i+11]));

                }
                i++; ind++;
            }
            else{
                ans[ind]+=arr[i]; ind++;
            }

        }
        return arr;
    }
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter math exp(only numbers and  4 operators no brackets) (A legit exp):");
        String exp=sc.nextLine();
        String [] s=new String[exp.length()];
        int ind=0;char ch;
        for(int i=0;i<exp.length();i++) s[i]="";
        for(int i=0;i<exp.length();i++)
        {

            ch=exp.charAt(i);
            if (Character.isDigit(ch))
             {
                 s[ind]+=ch;
            }
            else {ind++;s[ind]+=ch; ind++;}
        }

    }
}
