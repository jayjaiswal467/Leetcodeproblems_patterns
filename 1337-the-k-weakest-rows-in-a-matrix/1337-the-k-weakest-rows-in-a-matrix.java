import java.util.*;

class Pair{
    int first;
    int second;

    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {

        HashMap<Integer,Integer> f = new HashMap<>();

        for(int i=0;i<mat.length;i++){
            int count = 0;

            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 1)
                    count++;
            }

            f.put(i,count);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.first != b.first)
                    return a.first-b.first;
                return a.second-b.second;
            }
        );

        for(Map.Entry<Integer,Integer> i : f.entrySet()){
            int element = i.getKey();
            int freq = i.getValue();

            Pair curr = new Pair(freq,element);
            pq.offer(curr);
        }

        int[] res = new int[k];
        int index = 0;

        while(index < k){
            Pair curr = pq.poll();
            res[index++] = curr.second;
        }

        return res;
    }
}