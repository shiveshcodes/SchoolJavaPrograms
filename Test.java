

class Test
{
    public static void main(String[] args) {
        int[] arr={2,1,4,2,50};
        display(arr);
        display(bsort(arr));
    }
    
    public static int[] bsort(int[]arr)
    {
        int temp=0;       
        boolean sorted;
        for(int i=0;i<arr.length;i++)
        {
            sorted=true;
            for(int j=0;j<(arr.length-i-1);j++)
            {
                if(arr[j]>arr[j+1]) 
                {
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    sorted=false;
                }
            }
            if(sorted) break;
        }
        return arr;
    }
    
    public static void display(int[] arr)
    {
        for(int e:arr)
        System.out.print(e+"\t");
        System.out.println();
    }
}