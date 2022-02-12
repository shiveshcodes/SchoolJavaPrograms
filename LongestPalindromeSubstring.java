
class LongestPalindromeSubstring
{
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("babad"));
    }
    //Bruteforce Method
    public static String longestPalindrome(String s)
    {
        String ans="",temp="";
        for(int i =0;i<s.length();i++)
        {
            for(int j=i+1;j<=s.length();j++)
            {
                if((j-i)<ans.length()) continue;
                temp=s.substring(i,j);
                if(isPalindrome(temp) && temp.length()>ans.length()) ans=temp;
            }
        }

        return ans;
    }

    //Expand Around Centre https://leetcode.com/problems/longest-palindromic-substring/solution/

    public static String longestPalindrome2(String s)
    {
        int n=s.length();
        String ans="",temp="";
        if(n==0) return s;
        int i,j;
        for(float k=0f;k<n;k+=0.5f)
        {
            i=(int)Math.floor(k);
            j=(int)Math.ceil(k);
            while(i>=0 && j<n )
            {
                if(s.charAt(i)==s.charAt(j) && i!=j) 
                {
                    temp=s.charAt(i)+temp+s.charAt(j);

                }
                else if(i==j) temp=""+s.charAt(i);
                else break;
                i--;j++;
            }
            if(temp.length()>ans.length()) ans=temp;
            temp="";
        }
        return ans;

    }
    public static boolean isPalindrome(String s)
    {

        return s.contentEquals(new StringBuffer(s).reverse());
    }
}