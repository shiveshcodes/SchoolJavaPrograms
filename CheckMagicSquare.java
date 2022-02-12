

import java.util.*;
class CheckMagicSquare
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of square: ");
        int N=sc.nextInt();

        int[][] sq=new int[N][N];
        int[] sum=new int[2*N+2];

        System.out.println("Enter elements: ");

        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                sq[i][j]=sc.nextInt();

                sum[j]+=sq[i][j];
                sum[N+i]+=sq[i][j];
                if(i==j) sum[sum.length-2]+=sq[i][j];
                if(i==(N-j-1)) sum[sum.length-1]+=sq[i][j];
            }
        }

        boolean check=true;

        for(int sums:sum) if(sum[0]!=sums) { check = false; break;}

        if(check) System.out.println("Its a magic square");
        else System.out.println("Its not a magic square");
        
        sc.close();
    }
}