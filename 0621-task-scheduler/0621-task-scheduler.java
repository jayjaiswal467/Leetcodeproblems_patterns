import java.util.*;

class Pair {
    int first;       // frequency
    char second;     // task

    Pair(int first, char second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> freq = new HashMap<>();

        // Count frequency of every task
        for (int i = 0; i < tasks.length; i++) {
            freq.put(tasks[i], freq.getOrDefault(tasks[i], 0) + 1);
        }

        // Max heap based on frequency
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x, y) -> y.first - x.first
        );

        // Put all tasks into heap
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.offer(new Pair(entry.getValue(), entry.getKey()));
        }

        // Store the next time each task can be used
        HashMap<Character, Integer> free = new HashMap<>();

        int time = 0;

        while (!pq.isEmpty()) {

            ArrayList<Pair> temp = new ArrayList<>();

            Pair curr = null;

            // Find the highest-frequency task that is available
            while (!pq.isEmpty()) {

                Pair p = pq.poll();

                if (free.getOrDefault(p.second, 0) <= time) {
                    curr = p;
                    break;
                }

                temp.add(p);
            }

            // Put unavailable tasks back
            for (Pair p : temp) {
                pq.offer(p);
            }

            if (curr != null) {

                // Execute task
                curr.first--;

                // Task can be used again after n intervals
                free.put(curr.second, time + n + 1);

                // If task still remains, put it back
                if (curr.first > 0) {
                    pq.offer(curr);
                }
            }

            // One CPU interval has passed
            time++;
        }

        return time;
    }
}