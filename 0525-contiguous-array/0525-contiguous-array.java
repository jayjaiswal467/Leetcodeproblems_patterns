class Solution {
    public int findMaxLength(int[] a) {
        int zero=0;
        int one=0;
        int res=0;
        int n=a.length;

        HashMap<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<n;i++){
            if(a[i]==0){
                zero++;
            }
            else{
                one++;
            }

            int diff = zero - one;
            if(diff==0){
                res=Math.max(res,i+1);
                continue;
            }

            if (!map.containsKey(diff))  {
                //if it is not present then
                map.put(diff, i);           
                 }
            else{
                int idx = map.get(diff);
                int len = i - idx;

                res = Math.max(res,len);
                //no updation of  map
            }
    }
 return res;}
}