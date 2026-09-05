import java.util.*;

class Pair{
    int first;
    char second;

    Pair(int first,char second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public String reorganizeString(String s) {
        int n=s.length();

        HashMap<Character,Integer> f = new HashMap<>();

        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            f.put(ch,f.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (x,y)->{
                if(x.first!=y.first)
                    return y.first-x.first; //MAX HEAP ON FIRST

                return y.second-x.second;       //MAX HEAP ON SECOND
            }
        );

        for(Map.Entry<Character,Integer> i:f.entrySet()){
            char element=i.getKey();
            int freq=i.getValue();

            Pair p=new Pair(freq,element);
            pq.offer(p);
        }

        StringBuilder res=new StringBuilder();

        while(!pq.isEmpty()){

            Pair p=pq.poll();

            if(res.length()==0 || res.charAt(res.length()-1)!=p.second){

                res.append(p.second);
                p.first--;

                if(p.first>0){
                    pq.offer(p);
                }
            }

            else{

                if(pq.isEmpty()){
                    return "";
                }

                Pair p2=pq.poll();

                res.append(p2.second);
                p2.first--;

                if(p2.first>0){
                    pq.offer(p2);
                }

                pq.offer(p);
            }
        }

        return res.toString();
    }
}