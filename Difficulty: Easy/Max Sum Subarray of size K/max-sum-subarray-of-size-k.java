class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n = arr.length;
        int sum=0;
        
        for(int i=0;i<k;i++){
            sum=sum+arr[i];
        }
        
        int res = sum;
        int low=0;
        int high = k-1;
        
        while(high<n-1){
            low++;
            high++;
            
            sum=sum-arr[low-1];
            sum=sum+arr[high];
            
            res= Math.max(res,sum);
            
        }
        return res;
    }
}