import java.util.*;//Importing input classes
class DateSort
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter No. of Dates");//Size prompt
        String[] dates=new String[sc.nextInt()];//Array Declaration
        System.out.println("Enter Dates in DD/MM/YYYY format");//Format Prompt
        for(int i=0;i<dates.length;i++) dates[i]=sc.next();//Accepting Dates

        sortDates(dates);//Calling sorting function
        System.out.println(Arrays.toString(dates));//Printing Array

        sc.close();
    }

    public static void sortDates(String[] arr)
    {
        int N=arr.length;//Storing array length
        String temp;//for swapping
        boolean sorted;// To terminate the sorting if array is sorted
        for(int i=0;i<N;i++)//Typical bubble sort with custom compare function
        {
            sorted=true;//Sorted array assumed
            for(int j=0;j<N-i-1;j++)
            {
                if(compare(arr[j],arr[j+1])<0)
                {// Swapping
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    sorted=false;//If swap occurs, array isn't sorted
                }
            }
            if(sorted) break;//Terminating sorting if already sorted
        }
    }

    public static int compare(String d1, String d2)
    {
        //If d1 is older than d2 then output is negative and vice versa/
        int ans;
        //Subtracting years and months and days 
        if((ans=(Integer.parseInt(d1.substring(6))-Integer.parseInt(d2.substring(6))))!=0) return ans;
        if((ans=(Integer.parseInt(d1.substring(3,5))-Integer.parseInt(d2.substring(3,5))))!=0) return ans;
        if((ans=(Integer.parseInt(d1.substring(0,2))-Integer.parseInt(d2.substring(0,2))))!=0) return ans;
        return 0;// Zero return denotes equal dates
    }
}