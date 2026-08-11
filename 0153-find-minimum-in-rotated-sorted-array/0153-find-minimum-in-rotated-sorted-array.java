class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int n = nums.length-1;
        int res=-1;

        while(low<=high){
            int guess = (low+high)/2;

            if(nums[guess]>nums[n]){
                //yee part 2 hai direct move right 
                low=guess+1;
            }
            else{
                //part 1 hai iska result store kro aur move left agar isse bhi chota elemnt ho toh check krne ke liye 
                res = guess;
                high = guess-1;
            }
        }

    return nums[res];


    }
}