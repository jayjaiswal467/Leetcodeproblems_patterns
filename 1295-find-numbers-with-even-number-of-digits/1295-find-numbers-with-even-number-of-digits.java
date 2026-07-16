class Solution {

    public int findNumbers(int[] nums) {

        int evenCount = 0;

        for (int num : nums) {

            int digitCount = 0;
            int t = num;

            if (t < 0) {
                t = -t;
            }

            if (t == 0) {
                digitCount = 1;
            }

            while (t > 0) {
                digitCount++;
                t = t / 10;
            }

            if (digitCount % 2 == 0) {
                evenCount++;
            }
        }

        return evenCount;
    }
}