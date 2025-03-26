class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = (n*(n+1))/2;
        int newSum=0;
        for(int num:nums){
            newSum+=num;
        }

        return sum-newSum;

    }
}