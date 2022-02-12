
import java.util.Arrays;
//https://leetcode.com/problems/zigzag-conversion/submissions/

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s,int r)
    {
        if(s.equals("")) return s;
        String arr[]=new String[r];
        Arrays.fill(arr,"");     
        int k=0;
        outer: while(true)
        {
            for(int i=0;i<r;i++)
            {
                arr[i]+=""+s.charAt(k++);
                if(k==s.length()) break outer;
            }
             for(int i=r-2;i>0;i--)
            {
                arr[i]+=""+s.charAt(k++);
                if(k==s.length()) break outer;
            }
        }
        String ans="";
        for(String t:arr) ans+=t;
        return ans;
        
    }
}