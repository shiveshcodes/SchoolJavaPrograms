class MixedFraction extends Fraction
{
    public MixedFraction(int Numerator,int Denominator)
    {
        super(Numerator,Denominator);
    }
    public MixedFraction(int Numerator)
    {
        super(Numerator);
    }
    public String toString()
    {
        if(Numerator<Denominator) return super.toString();
        else if(Denominator==1) return Numerator+"";
        else
        {
            return (Numerator%Denominator)+" "+(Numerator/Denominator)+"/"+Denominator;
        }
    }
}