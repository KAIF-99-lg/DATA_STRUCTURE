class Solution {
    public int jump(int[] nums) {

    if(nums.length==1){
        return 0;
    }
        int maxreach = 0;
        int currentEnd=0;
        int jumps=0;
        for(int i=0;i<nums.length-1;i++){
            maxreach  = Math.max(maxreach,i+nums[i]);

            if(i==currentEnd){
                jumps++;
                currentEnd=maxreach;
            }
        }

        return jumps;
    }
}