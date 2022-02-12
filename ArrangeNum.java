import java.util.*;
class ArrangeNum
{
    int n;
    int[] s;
    public ArrangeNum(int nn) {n=nn;} 

    public void fill_array()
    {
        int i=0,m=n;
        while(m>0)
        {
            s[i]=m%10;
            i++;
            m/=10;
        }
    }

    public void arrange()
    {
        int min,minpos,temp;
        for(int i=0;i<s.length;i++)
        {
            min=s[i];
            minpos=i;
            for(int k=i+1;k<s.length;k++)
            {
                if(s[k]<min) {min=s[k]; minpos=k;}
            }
            temp=s[i];
            s[i]=min;
            s[minpos]=temp;
        }
    }

    public void show()
    {
        System.out.println(n);
        for(int j:s)
        {
            System.out.print(j);
        }
        System.out.println("Arranged");
    }

    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number");
        int num=sc.nextInt();
        int count=0;
        ArrangeNum obj=new ArrangeNum(num);
        while(num>0)
        {
            count++;
            num/=10;
        }
        obj.s=new int[count];
        
        obj.fill_array();
        obj.arrange();
        obj.show();
    }
}

