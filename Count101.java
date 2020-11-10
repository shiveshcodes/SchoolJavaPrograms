import java.io.*;
public class Count101 {
    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new FileReader("sample.txt"));
            String line; int count=0;
            while((line=br.readLine())!=null)
            count+=line.replace("1", "11").split("101").length-1;
            System.out.println("Number Of Occurences of '101': "+count);
        }catch(IOException e){}        
    }
}
