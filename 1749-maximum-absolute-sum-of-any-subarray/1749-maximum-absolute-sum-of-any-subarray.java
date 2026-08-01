class Solution {

    public int maxAbsoluteSum(int[] nums) {

        int maxEnding = nums[0];
        int maxAns = nums[0];

        int minEnding = nums[0];
        int minAns = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Maximum 
            maxEnding = Math.max(maxEnding + nums[i], nums[i]);
            maxAns = Math.max(maxAns, maxEnding);

            // Minimum 
            minEnding = Math.min(minEnding + nums[i], nums[i]);
            minAns = Math.min(minAns, minEnding);
        }

        return Math.max(Math.abs(maxAns), Math.abs(minAns));
    }
}