import java.util.*;
class Pair{
    int first;
    int second;

    Pair(int first,int second){
        this.first=first;
        this.second = second;
    }
}

class Solution {
    public int[] topKFrequent(int[] a, int k) {
        int n = a.length; 

        HashMap<Integer,Integer>f = new HashMap<>();

        PriorityQueue<Pair>pq = new PriorityQueue<>(
            (x,y) -> {
                if(x.first!=y.first)
                    return x.first-y.first;         //MIN HEAP FOR FIRST
                return x.second - y.second;         //MIN HEAP FOR SECOND
            }
        );

        for(int i=0;i<n;i++){
            f.put(a[i],f.getOrDefault(a[i],0)+1);       //STORE FREQUENCY OF EACH ELEMNET IN HASHMAP
        }

        for(Map.Entry<Integer,Integer>i:f.entrySet()){
            int element = i.getKey();
            int freq = i.getValue();

            Pair curr = new Pair(freq,element);

            if(pq.size()<k){
                pq.offer(curr);
                continue;
            }

            if(curr.first<pq.peek().first){
                continue;
            }
            pq.poll();
            pq.offer(curr);
        }

        int[] res = new int[k];
        int index=0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            res[index++] = curr.second;
        }
        return res;
    }
}