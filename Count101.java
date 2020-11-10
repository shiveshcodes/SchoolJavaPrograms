import java.io.*;
public class Count101 {
    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new FileReader("sample.txt")); // Attaching a reader to the file
            String line; int count=0;// stores line and count of pattern occurence
            while((line=br.readLine())!=null) // Extracts the different lines in a file
            count+=line.replace("1", "11").split("101").length-1; // 1's are doubled to identify shared set of pattern occurence
            System.out.println("Number Of Occurences of '101': "+count); // Display the count of pattern occurence
        }catch(IOException e){System.out.println(e);} // Displays error object's message  
    }
}
