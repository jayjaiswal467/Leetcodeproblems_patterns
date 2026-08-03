class Solution {
    public int pivotIndex(int[] nums) {
        int left=0;
        int  sum=0;

        for(int i=0;i<nums.length;i++){
             sum = sum+nums[i];
        }

        for (int j = 0; j < nums.length; j++) {

    if (j > 0)
        left += nums[j - 1];

    int right = sum - left - nums[j];

    if (left == right)
        return j;
}
    return -1;
    }
}