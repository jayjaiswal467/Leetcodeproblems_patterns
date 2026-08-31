import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> have = new HashMap<>();
        
        int low=0;
        int sum=0;
        int high=0;

        while(high<fruits.length){
            have.put(fruits[high],have.getOrDefault(fruits[high],0)+1);

            while(have.size()>2){
                have.put(fruits[low],have.get(fruits[low])-1);

                if(have.get(fruits[low])==0){
                    have.remove(fruits[low]);
                }
                low++;

                
            }
            sum=Math.max(sum,high-low+1);

                high++;
        }
    return sum;}
}