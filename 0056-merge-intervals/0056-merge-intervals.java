import java.util.*;

class Solution {
    public int[][] merge(int[][] a) {
        int n = a.length;

        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));

        List<int[]> res = new ArrayList<>();

        int start = a[0][0];
        int end = a[0][1];

        for (int i = 1; i < n; i++) {
            int s = a[i][0];
            int e = a[i][1];

            if (end >= s) {
                end = Math.max(end, e);
            } else {
                res.add(new int[]{start, end});
                start = s;
                end = e;
            }
        }

        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }
}