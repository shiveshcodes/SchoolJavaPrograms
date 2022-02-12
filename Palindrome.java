import java.util.*;
class Palindrome
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter :");
        StringBuffer s=new StringBuffer(sc.nextLine());
        System.out.println(s.toString().equals(new StringBuffer(s).reverse().toString()));
    }
}