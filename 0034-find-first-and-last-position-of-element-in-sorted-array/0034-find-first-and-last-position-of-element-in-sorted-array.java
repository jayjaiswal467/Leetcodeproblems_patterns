class Solution {

    public int[] searchRange(int[] nums, int target) {

        int res = first(nums, target);
        int ans = last(nums, target);

        return new int[]{res, ans};
    }


    public int first(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        int res = -1;

        while (low <= high) {

            int guess = (low + high) / 2;

            if (nums[guess] < target) {
                low = guess + 1;
            }

            else if (nums[guess] > target) {
                high = guess - 1;
            }

            else {
                res = guess;
                high = guess - 1;
            }
        }

        return res;
    }


    public int last(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        int ans = -1;

        while (low <= high) {

            int guess = (low + high) / 2;

            if (nums[guess] < target) {
                low = guess + 1;
            }

            else if (nums[guess] > target) {
                high = guess - 1;
            }

            else {
                ans = guess;

                // Search further right
                low = guess + 1;
            }
        }

        return ans;
    }
}