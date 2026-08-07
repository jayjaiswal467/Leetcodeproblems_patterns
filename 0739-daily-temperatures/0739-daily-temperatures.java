import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] a) {
        int n = a.length;
        Stack<Integer> st = new Stack<>();

        int[] res = new int[n];
        res[0]=0;
        st.push(n-1);

        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && a[st.peek()]<=a[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=0;
            }
            else{
                res[i]=st.peek()-i;
            }
          st.push(i);

        }
         return res;
    }
}