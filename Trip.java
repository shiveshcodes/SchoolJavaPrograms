import java.util.*;//importing input classes
class Trip
{
    public static void main(String[]args)
    {
        int N,exp[],avg,negsum,possum;//required variables
        String ans;//to format the output as desired
        Scanner sc=new Scanner(System.in);
        while((N=sc.nextInt())!=0)//Test Cases iterator
        {
            avg=0;negsum=0;possum=0;//initialization of required variables
            exp=new int[N];//integer array to avoid any floating complications
            for(int i=0;i<N;i++)
            {
                avg+=exp[i]=(int)(sc.nextDouble()*100);//0.01 precision adjustment
            }
            avg/=N;
            for(int i=0,temp;i<N;i++)//core logic is to find difference sum of avg and values and choose the smallest amongst
            {//amount given and amount received which are different only due to precision constraints.
                temp=avg-exp[i];
                if(temp>=0) possum+=temp;
                else negsum+=(-temp);              
            }
            ans=""+Math.min(possum,negsum);//storing smaller value in string to manipulate the output
            System.out.println("$"+ans.substring(0,2)+"."+ans.substring(2));//generates the desired output
        }
    }
}
 