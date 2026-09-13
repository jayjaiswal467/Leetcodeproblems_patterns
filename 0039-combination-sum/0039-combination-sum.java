import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] a, int target) {
        int n = a.length;

        List<Integer> diary = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        int idx = 0;
        int sum = 0;

        return fun(a, n, idx, res, diary, sum, target);
    }

    public List<List<Integer>> fun(int[] a, int n, int idx,
                                   List<List<Integer>> res,
                                   List<Integer> diary,
                                   int sum, int target) {

        if (idx == n) {
            if (sum == target) {
                res.add(new ArrayList<>(diary));
            }
            return res;
        }

        // nhi lena wala condition
        fun(a, n, idx + 1, res, diary, sum, target);

        // lena hai toh condition match krlo pehle
        if (a[idx] + sum <= target) {

            diary.add(a[idx]);
            sum = sum + a[idx];

            // idx same because same number can be used unlimited times
            fun(a, n, idx, res, diary, sum, target);

            diary.remove(diary.size() - 1);
            sum = sum - a[idx];
        }

        return res;
    }
}