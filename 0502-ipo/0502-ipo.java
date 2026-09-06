import java.util.*;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;

        ArrayList<Pair> projects = new ArrayList<>();

        // Store (capital, profit)
        for (int i = 0; i < n; i++) {
            projects.add(new Pair(capital[i], profits[i]));
        }

        // Sort projects according to capital
        Collections.sort(projects, (x, y) -> x.first - y.first);

        // Max heap based on profit
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (x, y) -> y - x
        );

        int idx = 0;

        while (k-- > 0) {

            // Add all affordable projects
            while (idx < n && projects.get(idx).first <= w) {
                pq.offer(projects.get(idx).second);
                idx++;
            }

            // No project can be selected
            if (pq.isEmpty()) {
                return w;
            }

            // Take maximum profit
            w += pq.poll();
        }

        return w;
    }
}