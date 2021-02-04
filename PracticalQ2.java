package ISC2016;
import java.util.*;
class PracticalQ2
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("INPUT: M = ");
        int M=sc.nextInt();
        if(M>3&&M<10)
        {
            int[][]A=new int[M][M];
            int[] in=new int[M*M-4*M+4];
            int index=0;
            for(int i=0;i<M;i++)
            {
                System.out.print("\t");
                for(int j=0;j<M;j++)
                {
                    A[i][j]=sc.nextInt();
                    if((i!=0&&i!=M-1) && (j!=0&&j!=M-1)) in[index++]=A[i][j];
                }
            }
            System.out.println("\nOUTPUT: \n\nORIGINAL MATRIX");
            display(A);
            index=0;
            in=bsort(in);
            for(int i=1;i<M-1;i++)
            {
                for(int j=1;j<M-1;j++)
                {
                    A[i][j]=in[index++];
                }
            }
            System.out.println("\nREARRANGED MATRIX");
            display(A);
            int diagsum=0;
            System.out.println("\nDIAGONAL ELEMENTS");
            for(int i=0;i<M;i++)
            {
                System.out.print("\t");
                for(int j=0;j<M;j++)
                {
                    if(i==j || i==(M-j-1)) 
                    {
                        System.out.print(A[i][j]+" "); 
                        diagsum+=A[i][j];
                    }
                    else System.out.print(" "); 
                }
                System.out.println();
            }
            System.out.println("\nSUM OF DIAGONAL ELEMENTS = "+ diagsum);
        }
        else
        {
            System.out.print("OUTPUT: THE MATRIX IS OUT OF RANGE");
        }

    }

    public static int[] bsort(int[]arr)
    {
        int temp=0;       
        boolean sorted;
        for(int i=0;i<arr.length;i++)
        {
            sorted=true;
            for(int j=0;j<(arr.length-i-1);j++)
            {
                if(arr[j]>arr[j+1]) 
                {
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    sorted=false;
                }
            }
            if(sorted) break;
        }
        return arr;
    }

    public static void display(int A[][])
    {
        
        for(int i=0;i<A[0].length;i++)
        {
            System.out.print("\t");
            for(int j=0;j<A[0].length;j++)
            {
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
    }
}
