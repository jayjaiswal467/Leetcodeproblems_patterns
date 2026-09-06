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
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b)->{
                if(a.first!=b.first)
                    return b.first-a.first;
                return b.second-a.second;
            }
        );

        for(int i=0;i<arr.length;i++){

            int diff = Math.abs(x-arr[i]);
            int index = arr[i];

            Pair p1 = new Pair(diff,index);

            if(pq.size()<k){
                pq.offer(p1);
                continue;
            }

            Pair top = pq.peek();

            if(p1.first<top.first ||
              (p1.first==top.first && p1.second<top.second)){
                pq.poll();
                pq.offer(p1);
            }
        }

        List<Integer> list = new ArrayList<>();

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            list.add(curr.second);
        }

        Collections.sort(list);

        return list;
    }
}