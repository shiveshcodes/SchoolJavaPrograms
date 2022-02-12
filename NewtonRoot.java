

import java.util.*;
public class NewtonRoot
{
    public static void main(String[]args)
    {
        //Default precision is till nearest hundredth
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        double N=sc.nextDouble();
        int count=0;
        double guess=N/2.0,prevguess=0.0;
        while((int)(guess*10000)!=(int)(prevguess*10000))
        {
            prevguess=guess;
            guess-=((guess*guess-N)/2*guess);
            count++;
        }
        System.out.println(guess+"  "+count);
        sc.close();

    }

}