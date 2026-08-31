import java.util.*;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int low=0;
        int min = Integer.MAX_VALUE;
        int sum=0;

        for(int high=0;high<nums.length;high++){
            sum=sum+nums[high];

            while(sum>=target){
                int res = high - low + 1;
                min = Math.min(res,min);

                sum=sum-nums[low];
                low++;

            }
            
        }
        if(min==Integer.MAX_VALUE){
            return 0 ;
        }
        
    return min;
    }
}