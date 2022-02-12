import java.util.*;//importing input class

class Zagged_Pascal
{
    public static void main(String[]args)
    {
        System.out.print("Enter the length of the triangle: ");//Prompting User
        int N=new Scanner(System.in).nextInt();//Accepting input
        int[][] triangle = new int[N][];//Zagged Array Declaration

        for(int row=0;row<N;row++)
        {

            for(int space=0;space<N-row-1;space++) System.out.print(" ");//Printing spaces for triangle

            triangle[row]=new int[row+1];//Creating column of zagged array of required length
            triangle[row][0]=triangle[row][row]=1;//Initializing first and last values of a row
            for(int col=1;col<row;col++)//Filling up rows according to pascal triangle's logic
            {
                triangle[row][col]=triangle[row-1][col-1]+triangle[row-1][col];
            }

            for(int element:triangle[row])//Iterating the row just created above
            {
                System.out.print(element+" ");
            }

            System.out.println("\b");//Changing the current line while erasing the unnecessary trailing space
        }
    }
}
 