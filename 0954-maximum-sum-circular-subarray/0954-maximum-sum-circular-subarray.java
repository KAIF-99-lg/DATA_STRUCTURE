class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int max = 0;
        int minSum = Integer.MAX_VALUE;
        int min = 0;

        int totalSum=0;

        for(int num:nums){
            max = Math.max(num,max+num);
            maxSum = Math.max(maxSum,max);

            min = Math.min(num,min+num);
            minSum = Math.min(minSum,min);

            totalSum+=num;
        }

        return (maxSum>0)?Math.max(maxSum,totalSum-minSum):maxSum;
    }
}