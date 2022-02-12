

import java.util.*;//Input Packages
class Determinent
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the size of the array: ");//User prompt
        int N=sc.nextInt();//Accepting size
        int arr[][]=new int[N][N];//Array Declaration
        for(int i=0;i<N;i++)//Standard 2-D Array Input nested loops
        {
            for(int j=0;j<N;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(calcDeterminent(arr));//Method call to recursive function and result display
        sc.close();
    }

    public static int calcDeterminent(int[][] matrix)
    {
        if(matrix.length!=matrix[0].length) return 0;//Checking Square Array
        //Zagged Array have not been considered as its not even a mathematical matrix
        int size=matrix.length;

        if(size==1) return matrix[0][0];//Base Condition
        else
        {//Standard method to calc n*n determinent
        int subcol=0,determinent=0,sign=1;
        int[][] submatrix=new int[size-1][size-1];//To store the matrix after eliminating row and col
        for(int i=0;i<size;i++)//Solving via first row
        {
            for(int k=1;k<size;k++)
            {
                for(int j=0;j<size;j++)
                {
                    if(j==i) continue;//Ignoring current col
                    submatrix[k-1][subcol++]=matrix[k][j];//Filling up submatrix
                }
                subcol=0;
            }
            determinent+=matrix[0][i]*sign*calcDeterminent(submatrix);//Mathematical Formula
            sign*=-1;//Sign keeper variable
        }
        return determinent;//Returning determinent
    }
    }
}