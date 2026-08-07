import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] a) {

        int n = a.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        Stack<Integer> st = new Stack<>();

        // Traverse twice because the array is circular
        for (int i = 2 * n - 1; i >= 0; i--) {

            int idx = i % n;

            while (!st.isEmpty() && st.peek() <= a[idx]) {
                st.pop();
            }

            if (i < n) {
                if (!st.isEmpty()) {
                    res[idx] = st.peek();
                }
            }

            st.push(a[idx]);
        }

        return res;
    }
}