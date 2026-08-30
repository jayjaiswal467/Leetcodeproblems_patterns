class Solution {
    public int removeDuplicates(int[] nums) {
        
        int atmost = 2;
        int officer=1;
        int cm=2;

        while(cm<nums.length){
            if(nums[cm]==nums[officer-1]){
                cm++;
                continue;

            }
            nums[officer+1]=nums[cm];
            officer++;
            atmost++;
            cm++;
        }

        if(nums.length<=2){
            return nums.length;
        }
    return atmost;
    }
}