import java.util.*;
/**
 * The main function designed yields two lines of answer by two separate methods.
 * In case of any anomaly between the two, the first output is to be considered as the final answer.
 */
class FloatToBinary
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);//Scanner object
        System.out.println("Enter the number: ");//Prompt
        float in=sc.nextFloat();//accepting inut
        
        //direct answer by manipulating output from predefined functions
        String ans="00000000000000000000000000000000"+Integer.toBinaryString(Float.floatToIntBits(in));
        ans=(in<0?"1":"0")+ans.substring(ans.length()-31);
        System.out.println(ans.substring(0,9)+" "+ans.substring(9));
        
        //answer using custom designed function
        System.out.println(floatToBinary(in));
       ftb(in);
        
    }

    public static String floatToBinary(float in)
    {
        String bin ="";

        double decimal=Math.abs(in);
        int integer=(int)decimal;
        int exp=0;String mantissa="";
        if((int)in==0)//when decimal shifts towards right
        {
            int i=1;boolean occ=false;//occ identifies occurence of 1
            while(i<=24)
            {   //multiplies decimal part by 2 and starts storing integral part after first occurence of 1      
                decimal=decimal-integer;
                decimal*=2;
                integer=(int)decimal; 
                if(occ||integer==1)//first occ of 1
                {
                    mantissa+=integer;
                    i++;
                    occ=true;
                }                   
                else if(!occ) 
                {
                    exp++;//counting decimal shifts until 1 occurs
                }
            }
            exp=127-exp-1;//exponent bias
        }
        else//when decimal shifts towards left
        {
            int i=1;
            while(i<=23)
            {   //as decimal will shift to right so exact iteration can be performed
                decimal=decimal-integer;
                decimal*=2;
                integer=(int)decimal; 
                mantissa+=integer;
                i++;
            }
            //normalization with integer part of number
            String temp = Long.toBinaryString((long)in);
            exp=127+(temp.length()-1);
            mantissa=temp+mantissa;
        }
        //extracting exact mantissa
        mantissa=mantissa.substring(1,24);
        bin+=mantissa;
        //an attempt to reuse the memory of String named mantissa inorder to get exponent part
        mantissa="00000000"+Integer.toBinaryString(exp);
        bin=mantissa.substring(mantissa.length()-8)+" "+bin;       
        
        bin=(in<0?"1":"0")+bin;//adding sign part
        return bin;
    }
    
    public static void ftb(float n)

    {


        int signbit = (n>=0 ? 0 : 1);

        n = Math.abs(n);                       // ex) 1.34 -> integral = 1 , real = 0.34 

        int integral = (int) Math.floor(n), exponent = 0;

        float real = n-integral;

        String binaryIntegral="", binaryReal="", binaryExponent="", mantissa="";

        boolean firstNonZeroOccured = false;

        if(integral>=1)

        {

            while(integral>0)

            {

                if(integral%2==1)firstNonZeroOccured=true;

                else if(!firstNonZeroOccured)exponent++;

                binaryIntegral = (integral%2) + binaryIntegral;

                integral >>>= 1;

            }

            for(int i=0;i<23;i++)

            {

                real *= 2;

                binaryReal += (int)(real);

                if(real>=1)real--;

            }

            mantissa=(binaryIntegral.substring(1)+binaryReal).substring(0,24);

        }

        else

        {

            for(int i=0;i<23;i++)

            {

                real *= 2;

                binaryReal += (int)(real);

                if(!firstNonZeroOccured)exponent--;

                if(real>=1)

                {

                    real--;

                    firstNonZeroOccured=true;

                }

            }

            mantissa=binaryReal.substring(Math.abs(exponent));

            for(int i=exponent;i<0;i++)mantissa+='0';

        }

        exponent+=127;

        for(int i=0;i<8;i++)

        {

            binaryExponent = (exponent%2) + binaryExponent;

            exponent >>>= 1;

        }

        System.out.println(signbit+" "+binaryExponent+" "+mantissa);

    }

}