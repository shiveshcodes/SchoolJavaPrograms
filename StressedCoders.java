
import java.util.*;//Input classes
public class StressedCoders {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the coder count: ");//User Prompt
        int N=sc.nextInt();//No. of coders
        System.out.println("Enter the skills: ");
        int[] S=new int[N];
        int sum=0,last=1;
        for(int i=0;i<N;i++)
        {
             S[i]=sc.nextInt();//Storing skills
             sum+=S[i];//total sum - eliminated sum will give answer
        }
        Arrays.sort(S);//Ascending sort
        for(int i=0;i<N;i++)
        {
            for(int j=last;j<N;j++)
            {
                if(S[j]>S[i])//Fixing a min and searching for a person to kill it
                {
                    sum-=S[i];//If killed the no. is removed from sum
                    last=j+1;//searching var always starts ahead of the point already used
                    break;
                }
            }
        }
        System.out.println(sum);//Total - eliminated is answer
        sc.close();//Avoiding memory leak
    }
}