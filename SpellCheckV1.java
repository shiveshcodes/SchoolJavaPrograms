
import java.io.*;
class SpellCheckV1
{
    // dictionary here !
    //Happy Programmers! :)
    private final static int DICT_SIZE=178691;
    private static String[] dictionary=new String[DICT_SIZE],words;
    private static char[] invalid={'.',',','!','$','?','(',')',';',':','#','^'};
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new FileReader("sample.txt"));
        BufferedReader dict=new BufferedReader(new FileReader("dictionary.txt"));
        loadDictionary(dict);
        dict.close();
        String in;
        System.out.println("Incorrect words :");
        while((in=br.readLine())!=null)
        {
            words=in.split(" ");
            for(String i:words)
            {
                for(char j:invalid) {
                    i=i.replace(j,' ');
                }
                i=i.trim();
                if(!isCorrect(i))System.out.println(i);
            }
        }
        br.close();
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