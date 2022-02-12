
import java.util.Random;//To get random index
class Pack extends Deck
{
    public void shuffle()
    {
        Random rn=new Random();//Object Initialization of Random class
        String temp;//For swapping
        for(int i=51,index;i>0;i--)
        {
            index=rn.nextInt(i);//Index chosen out of [0,i) Range to ensure all cards are shuffled
            //Swapping
            temp=deck[i];
            deck[i]=deck[index];
            deck[index]=temp;           
        }
    }
    
    public static void main(String[]args)
    {
        Pack dc=new Pack();//Object Creation
        //All fuctions comply with their literal meaning 
        System.out.println("Original Deck");
        dc.display();
        dc.shuffle();
        System.out.println("\nShuffled Deck");
        dc.display();
    }
}