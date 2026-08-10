class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        int low=0;
        int high = arr.length-1;
        int res=-1;
        
        while(low<=high){
            int guess = (low+high)/2;
            
            if(arr[guess]<x){
                low=guess+1;
            }
            else{
                res = guess;
                high=guess-1;
            }
        }
            
    return res;        
        
    }
}
