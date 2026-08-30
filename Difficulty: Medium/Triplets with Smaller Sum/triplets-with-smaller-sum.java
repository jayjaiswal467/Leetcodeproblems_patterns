import java.util.*;

class Solution {
    int countTriplets(int target, int arr[]) {
        // code here
        Arrays.sort(arr);
        int ans=0;
        for(int i=0;i<arr.length-2;i++){
            int left = i+1;
            int right = arr.length-1;
            
            while(left<right){
                int sum = arr[i]+arr[left]+arr[right];
                
                if(sum>=target){
                    right--;
                }
                else{
                     ans = ans+(right-left);
                    left++;
                }
            }
        }
    return ans;
        
    }
}