class Solution {
    public int search(int[] a, int target) {
        
        int low=0;
        int n = a.length;
        int high = a.length-1;

        while(low<=high){
            int guess = (low+high)/2;

            if(a[guess]==target){
                return guess;
            }

            //PART 1 MEIN GUESS LAND HUA HAI
            if(a[guess]>a[n-1]){
                if(a[guess]<target){
                    //move right
                    low=guess+1;
                }
                else{
                    if(a[0]>target){
                        //move right
                        low=guess+1;
                    }
                    else{
                        high=guess-1;
                    }
                }
            continue;
            }


            //PART 2 MEIN GUESS LAND HUA HAI
            if(a[guess]>target){
                //move left
                high=guess-1;
            }
            else{
                if(a[n-1]<target){
                    //move left
                    high=guess-1;
                }
                else{
                    //move right
                    low=guess+1;
                }
            }
        }
        return -1;
    }
}