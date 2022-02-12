import java.util.*;
class BigNumSum
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first number: ");//Input prompt 
        String big=sc.nextLine();//Taking input
        System.out.println("Enter second number: ");
        String small=sc.nextLine();
       
        if(big.length()<small.length())//assigning bigger string to big and smaller to small
        {
            String temp=big;
            big=small;
            small=big;
        }
        
        for(int i=big.length()-small.length();i>=1;i--) small="0"+small;//evenizing length of both strings by filling 0
      
        String result="";
        int temp=0;
        
        for(int i=big.length()-1;i>=0;i--)
        {
            //Typical manual addition method implementation
            temp=Integer.parseInt(big.charAt(i)+"")+Integer.parseInt(small.charAt(i)+"")+temp;
            result=(temp%10)+result;
            temp=temp/10;//carry over
        }
        result=temp+result;//Handling last carryover
        
        System.out.println(result);//displaying result
    }
}