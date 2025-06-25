class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);

        return Math.max(helper(nums,0,nums.length-2),helper(nums,1,nums.length-1));
    }

    public int helper(int nums[],int start,int end){
        int prev1=0;
        int prev2=0;

        for(int i=start;i<=end;i++){
            int current = Math.max(nums[i]+prev2,prev1);
            prev2=prev1;
            prev1=current;
        }

        return prev1;
    }
}