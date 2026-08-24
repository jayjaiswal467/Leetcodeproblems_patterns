import java.util.*;

class Solution {
    public int minEatingSpeed(int[] a, int guard) {
       int  n=a.length;
        int low=1;
        int res=-1;

        //high calculate kne ke liye array ka max value find krle vahi hai uski high value
        int max = Integer.MIN_VALUE;
        for(int p=0;p<=n-1;p++){
            if(a[p]>max){
                max=a[p];
            }
        }

        int high = max;

        while(low<=high){
            int speed=(low+high)/2;
            
            long hour = hourcalc(a,n,speed);
            if(hour>guard){
                low=speed+1;
            }
            else{
                res=speed;       //SAME FIRST OCCURENCE LOGIC APPLIED HERE
                res=speed;
                high=speed-1;
            }
        }
        return res;
    }

    public long hourcalc(int[] a,int n,int speed){
        long h=0;

        for(int i=0;i<n;i++){
            h=h+a[i]/speed;
            if(a[i]%speed!=0){
                h=h+1;
            }
        }
    return h;
    }
}