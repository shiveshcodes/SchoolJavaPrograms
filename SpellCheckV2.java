
import java.io.*;
class SpellCheckV2
{
    // dictionary here !
    //Happy Programmers! :)
    private final static int DICT_SIZE=178691;
    private static String[] dictionary=new String[DICT_SIZE],words;
    private static String Red="\u001b[31m";
    private static String Reset="\u001b[0m";
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader("sample.txt"));
        PrintWriter wr=new PrintWriter(new FileWriter("sample.html"));
        BufferedReader dict=new BufferedReader(new FileReader("dictionary.txt"));
        loadDictionary(dict);
        dict.close();
        String in;
        String temp="";
        char ch;
        while((in=br.readLine())!=null)
        {
            for(int i=0;i<in.length();i++)
            {
                ch=in.charAt(i);
                if(Character.isLetter(ch)) temp+=ch+"";
                if(!Character.isLetter(ch))
                {
                    if(isCorrect(temp)) wr.print(temp);
                    else wr.print(Red+temp+Reset);
                    temp="";
                    wr.print(ch);
                }
            }
            wr.println();
        }
        br.close();
        wr.close();
    }
    
    private static boolean isCorrect(String word)
    {
        int lb=0,ub=dictionary.length-1,mid;
        String curr;
        word=word.toUpperCase();
        while(lb<=ub)
        {
            mid=(lb+ub)/2;
            curr=dictionary[mid];
            if(curr.equals(word)) return true;
            else if(curr.compareTo(word)>0) ub=mid-1;
            else lb=mid+1;
        }
        return false;
    }
    
    private static void loadDictionary(BufferedReader brc) throws IOException
    {
        int wordNo = 0; //To Keep Track of the Word Number
        String line = ""; 
        while((line = brc.readLine())!=null) { //Checking if it's not the E.O.F
        
            dictionary[wordNo++] =  line; // Assigning Words to the Dictionary Array
        }
        brc.close();
    }
}