class Solution {
    static int smallestSumSubarray(int a[], int size) {
        // your code here
        int bestending = a[0];
        int ans=a[0];
        
        for(int i=1;i<a.length;i++){
            int v1 = bestending+a[i];
            int v2 = a[i];
            
            bestending = Math.min(v1,v2);
            
            ans=Math.min(ans,bestending);
        }
        return ans;
    }
}