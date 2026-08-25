import java.util.*;

class Solution {
    public int aggressiveCows(int[] arr, int k) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        
        int low=1;
        int high=arr[n-1];
        int res=-1;
        
        while(low<=high){
            int guess = (low+high)/2;
            
            if(poscalc(arr,n,k,guess)){
                res=guess;
                low=guess+1;
            }
            else{
                high = guess-1;
            }
        }
        
    return res;
        
    }
    
    public boolean poscalc(int[] arr,int n,int k,int guess){
        int cows =1;
        int prevpos = arr[0];
        
        
        for(int i=1;i<n;i++){
            int distance = arr[i] - prevpos;
            
            if(distance<guess){
                continue;
            }
            cows++;
            prevpos=arr[i];
        }
    
        if(cows>=k){
            return true;
        }
        else{
            return false;
        }
    }
    
}