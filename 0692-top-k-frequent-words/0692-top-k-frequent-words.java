import java.util.*;

class Pair{
    int first;
    String second;

    Pair(int first,String second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x,y)->{
                if(x.first != y.first)
                    return x.first - y.first;
                return y.second.compareTo(x.second);
            }
        );

        HashMap<String,Integer> f = new HashMap<>();

        for(int i=0;i<words.length;i++){
            f.put(words[i],f.getOrDefault(words[i],0)+1);
        }

        for(Map.Entry<String,Integer> i : f.entrySet()){
            String element = i.getKey();
            int freq = i.getValue();

            Pair curr = new Pair(freq,element);

            if(pq.size() < k){
                pq.offer(curr);
                continue;
            }

            if(curr.first > pq.peek().first ||
               (curr.first == pq.peek().first &&
                curr.second.compareTo(pq.peek().second) < 0)){
                pq.poll();
                pq.offer(curr);
            }
        }

        List<String> res = new ArrayList<>();

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            res.add(curr.second);
        }

        Collections.reverse(res);

        return res;
    }
}