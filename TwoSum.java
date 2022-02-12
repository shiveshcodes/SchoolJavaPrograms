
import java.util.*;
public class TwoSum {
     public static void main(String[] args) {
         int a[]={1,2,7,11,15};
         System.out.println(Arrays.toString(twoSum(a,9)));
     }
    public static int[] twoSum(int[] nums, int target) {
        int i=0,j=0;
        outer: for(; i <nums.length;i++)
        {
            for(j=i+1;j<nums.length;j++)
            {
                if((nums[i]+nums[j])==target) break outer;
            }
        }
       int ans[] = {i,j};
        return ans;
}
}