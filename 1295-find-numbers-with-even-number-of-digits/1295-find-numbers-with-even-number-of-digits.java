class Solution {

    public int findNumbers(int[] nums) {

        int count = 0;

        for (int num : nums) {
            if (even(num)) {
                count++;
            }
        }

        return count;
    }

    public boolean even(int num) {

        int nod = digit(num);

        return nod % 2 == 0;
    }

    public int digit(int num) {

        if (num < 0) {
            num = -num;
        }

        if (num == 0) {
            return 1;
        }

        int count = 0;

        while (num > 0) {
            count++;
            num = num / 10;
        }

        return count;
    }
}