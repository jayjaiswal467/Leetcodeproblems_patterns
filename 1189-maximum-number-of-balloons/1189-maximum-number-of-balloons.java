import java.util.*;

class Solution {
    public int maxNumberOfBalloons(String s) {
        
        HashMap<Character,Integer> have = new HashMap<>();

        for(int i =0;i<s.length();i++){
            have.put(s.charAt(i),have.getOrDefault(s.charAt(i),0)+1);

        }

        HashMap<Character,Integer> need = new HashMap<>();
        need.put('b',1);
        need.put('a',1);
        need.put('l',2);
        need.put('o',2);
        need.put('n',1);

        int res = Integer.MAX_VALUE;
        
        for(char c:need.keySet()){
            char first = c;
            int fneed = need.get(c);
            int fhave = have.getOrDefault(c,0);

            int times = fhave/fneed;
            
            res=Math.min(res,times);
        }
    return res;
    }
}