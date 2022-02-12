import java.util.*;
class MyString
{
    String str;
    public MyString()
    {
        
    }
    public void accept()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Sentence");
        str=sc.nextLine().toUpperCase();
        sc.close();
    }
    public boolean check(String s)
    {
        return s.charAt(0)==s.charAt(s.length()-1);
    }
    public void show()
    {
        System.out.println("Sentence : "+str);
        Scanner words=new Scanner(str);
        String wrd;
        while(words.hasNext())
        {
            if(check((wrd=words.next())))  System.out.println(wrd);
        }
        words.close();
    }
    public static void main(String[]args)
    {
        MyString obj=new MyString();
        obj.accept();
        obj.show();
    }
}