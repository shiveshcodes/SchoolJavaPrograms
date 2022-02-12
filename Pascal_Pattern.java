import java.util.*;
class Pascal_Pattern
{
    public static void pt(int n)
    {
        for(int i=1,k;i<=n;i++)
        {
            for(int j=1;j<=n-i-1;j++)
            {
                System.out.print(" ");
            }
            if(i==n){System.out.print("*"); k=2;}
            else k=1;
            for(;k<=i;k++)
            {              
                System.out.print(" *");
            }
            System.out.println();
        }
    }
    
    public static void pt2(int n)
    {
        for(int i=1,k;i<=n;i++)
        {
            for(int j=1;j<=n-i;j++)
            {
                System.out.print(" ");
            }
           
            for(k=1;k<=2*i-1;k++)
            {  
                if(k%2==0)
                System.out.print(" ");
                else
                System.out.print((char)(((k+1)/2)+64));
            }
            System.out.println();
        }
    }
}

    