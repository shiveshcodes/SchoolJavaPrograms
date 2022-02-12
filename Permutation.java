import java.util.Scanner;
class Permutation
{
    public static void main(String [] args)
    {
        System.out.println("Enter string :");
        String in=new Scanner(System.in).nextLine();
        permutations(in);
    }
    private static int dec=48;
    private static void permutations(String in)
    {
        int[] chk=new int[125-dec];
        for(int i=0;i<in.length();i++)chk[in.charAt(i)-dec]=1;
        perms(in,chk,"",1);
    }
    private static void perms(String n, int[] chk, String last, int lv)
    {
        if(n.length()==1){System.out.println(last+n);return;}
        String inverted="";
        for(int i=0;i<n.length();i++)
        {
            if(chk[n.charAt(i)-dec]<=lv)
            {
                perms(n.substring(0,i)+n.substring(i+1),chk,last+n.charAt(i),lv+1);
                chk[n.charAt(i)-dec]=lv+1;
                inverted+=(char)(n.charAt(i)-dec);
            }
        }
        for(int i=0;i<inverted.length();i++)chk[inverted.charAt(i)]=lv-1;
    }
}