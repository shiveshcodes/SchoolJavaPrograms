import java.util.*;//Importing input class
class Fraction
{
    int Numerator,Denominator;//class variables

    public Fraction(int Num,int Den)//basic constructor for function's object
    {
        Numerator=Num;
        Denominator=Den;
        Simplify();
    }

    public Fraction(int Num)//overloaded constructer to accomodate single integer
    {
        Numerator=Num;
        Denominator=1;
    }

    public void Simplify()//Fundamental simplification logic for fractions
    {
        int HCF=HCF(Numerator,Denominator);
        Numerator/=HCF;
        Denominator/=HCF;
    }

    public String toString()//to display fraction in simplified form
    {
        return (Numerator+"/"+Denominator);//Tradition format
    }

    public Fraction add(Fraction ...var)//Use of variable arguments in add function
    {
        //The addition of the fraction takes place pair-wise in the traditional way by taking LCM of Denominator
        int LCM = LCM(this.Denominator,var[0].Denominator);
        int Numerator=this.Numerator*(LCM/this.Denominator)+var[0].Numerator*(LCM/var[0].Denominator);//General rule of Maths
        int Denominator=LCM;//LCM of two denominators is the final denominator
        for(int i=1;i<var.length;i++)//performing pair-wise addition operation similar to above
        {
            LCM = LCM(Denominator,var[i].Denominator);
            Numerator=Numerator*(LCM/Denominator)+var[0].Numerator*(LCM/var[0].Denominator);
            Denominator=LCM;            
        }
        return new Fraction(Numerator,Denominator);//finally creating the fraction object to return
    }

    private static int HCF(int divisor,int divident)//General HCF Function
    {
        int remainder=1;
        while(remainder!=0)
        {
            remainder=divident%divisor;
            divident=divisor;
            divisor=remainder;
        }
        return divident;
    }

    private static int LCM(int a,int b)
    {
        return (a*b)/HCF(a,b);//Math's Rule : Product of two Number=Product of its LCM and HCF
    }

    public static void main(String[]args)//Driver Function for testing
    {
        Fraction f1 = new MixedFraction(4,3);
        Fraction f2= new Fraction(1,4); 
        Fraction f3=f1.add( f2);
        System.out.println( f1 ); //4/3
    }
}