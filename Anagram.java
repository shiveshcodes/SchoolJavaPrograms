// Tar = Rat
// Arc = Car
// Elbow = Below
// State = Taste
// Cider = Cried
// Dusty = Study
// Night = Thing
// Inch = Chin
// Brag = Grab
// Cat = Act
// Bored = Robed
// Save = Vase
// Angel = Glean
// Stressed = Dessclas

import java.io.*;
class Anagram
{
    private static int DICT_SIZE=178691;
    public static String[] arr;
    public static PrintWriter pw;
    private static String buffer;
    private static boolean hasAnagrams=false,done;
    private static int[] indexed;
    public static void permutations(String in)
    {
        buffer=in;
        done=false;
        perms("",in);
    }
    private static void perms(String c , String s)
    {
        if(s.length()==0) pw.print(s);
        else if(s.length()==2)
        {
            String temp;
            temp=c+s;
            if(validatePermutation(temp) && !temp.equals(buffer))
            {
                if(done)return;
                pw.println(temp);
                hasAnagrams=true;
            }
            temp=c+s.charAt(1)+s.charAt(0);
            if(validatePermutation(temp)&& s.charAt(1)!=s.charAt(0))
            {
                if(done)return;
                pw.println(temp);
                hasAnagrams=true;
            }
        }
        else
        {
            for(int i=0;i<s.length();i++)
            {
                if(s.indexOf(s.charAt(i))!=i) continue;
                perms(c+s.charAt(i),s.replaceFirst(s.charAt(i)+"", ""));
            }
        }
    }
    private static int mid,high,low;
    public static boolean validatePermutation(String str) 
    {
        low=indexed[Character.toUpperCase(str.charAt(0))-65];
        high=indexed[Character.toUpperCase(str.charAt(0))-64]-1;
        while(high>=low) 
        {
            mid=(high+low)/2;
            if(arr[mid].equalsIgnoreCase(str))
            {
                if(buffer.compareTo(arr[mid])>0)done=true;
                return true;
            }
            else if(arr[mid].compareTo(str)<0)low=mid+1;
            else high=mid-1;
        }
        return false;
    }
    public static void loadDictionary() throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));
        String line;
        int i=0;
        int j=1;
        arr=new String[DICT_SIZE];
        indexed=new int[26];
        indexed[0]=0;
        while((line=br.readLine())!=null)
        {
            arr[i++]=line;
            if(j+65==(int)arr[i-1].charAt(0))
            {
                indexed[j++]=i-1;
            }
        }
        br.close();      
    }
    public static void main(String[] args) throws IOException
    {
        loadDictionary();
        pw= new PrintWriter(new FileWriter("Anagram.txt"));
        for(int i=0;i<50;i++) //reduced
        {
            permutations(arr[i]);
            if(hasAnagrams){pw.println(buffer);pw.println();}
            hasAnagrams=false;
            pw.flush();
        }
        pw.close();
    }
}