class Solution {

    public int findNumbers(int[] nums) {

        int evenCount = 0;

        for (int num : nums) {

            int digitCount = 0;
            int temp = num;

            // Handle negative numbers (optional)
            if (temp < 0) {
                temp = -temp;
            }

            // Handle 0 separately
            if (temp == 0) {
                digitCount = 1;
            }

            while (temp > 0) {
                digitCount++;
                temp = temp / 10;
            }

            if (digitCount % 2 == 0) {
                evenCount++;
            }
        }

        return evenCount;
    }
}