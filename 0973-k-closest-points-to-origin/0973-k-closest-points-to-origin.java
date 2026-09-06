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
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x,y) -> y.first-x.first
        );

        for(int i=0;i<points.length;i++){

            int x=points[i][0];
            int y=points[i][1];

            int dist=x*x+y*y;

            pq.offer(new Pair(dist,i));

            if(pq.size()>k){
                pq.poll();
            }
        }

        int[][] res = new int[k][2];

        for(int i=0;i<k;i++){
            Pair curr=pq.poll();

            int index=curr.second;

            res[i][0]=points[index][0];
            res[i][1]=points[index][1];
        }

        return res;
    }
}