
public class Regex {

    public static void main(String[] args) {
        System.out.println(isMatch2("aa","a*"));
    }

    public static boolean isMatch(String s,String p)
    {
        return s.matches(p);
    }
    public static boolean isMatch2(String s,String p)
    {
        
        s=" "+s;
        p=" "+p;
        int ns=s.length();
        int np=p.length();
        char sc,pc;
        boolean dp[][] = new boolean[ns][np];
        dp[0][0]=true;
        for(int i=1;i<ns;i++)
        {
            dp[i][0]=false;
            if(p.charAt(i)=='*') dp[0][i]=dp[0][i-2];
        } 
        for(int i=1;i<np;i++)
        {
            for(int j=1;j<np;j++)
            {
                sc=s.charAt(i);
                pc=p.charAt(j);
                if(sc==pc || pc=='.') 
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else if(pc=='*')
                {
                    if(dp[i][j-2]) dp[i][j]=true;
                    else if(sc==p.charAt(j-1)||p.charAt(j-1)=='.') dp[i][j]=dp[i-1][j];
                }
                else dp[i][j]=false;
            }
        }
        return dp[ns-1][np-1];
    }
}