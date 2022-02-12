import java.util.*;//Input Class Import
class Golomb_Sequence
{
    public static void main(String[]args)
    {
        System.out.print("Enter the limit: ");//User Prompt
        int num=1,count=0,N=new Scanner(System.in).nextInt();//Necessary Variables
        if(N<1) { System.out.println("Invalid Input"); return;}
        int[] occ=new int[N+2]; occ[1]=1; occ[2]=2;//Array to store number of occurence of a number (N+2) eliminates extra 
        //verification of N=1,2
        outer:while(true)//It updates the number to be printed
        {
            for(int j=1;j<=occ[num];j++)//It prints a number the required number of times;
            {
                System.out.print(num+" ");
                if(++count==N) break outer;//Terminates the outer loop when requirement is met
                occ[count]=num;//It stores the number of occurence for a number
            }
            num++;//Updates the number to be printed
        }
    }
}