
import java.io.*;
class VerticalFloyd
{
    public static void main(String[] args) throws IOException
    {
        PrintWriter pw = new PrintWriter(new FileWriter("Pattern.txt"));
        int n=10;
        int prev;
        for(int i=1;i<=n;i++)
        {
            prev=i-n;
            for(int j=1;j<=i;j++)
            {
               pw.print((prev=prev+(n-j+1)));
               if(!(j==i)) pw.print(" ");
            }
            pw.println();
        }
        pw.close();
    }
}