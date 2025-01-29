class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> set = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int first_element = nums[i];
            int second_element = target - nums[i];
            if(set.containsKey(second_element)){
                return new int[]{i,set.get(second_element)};
            }
            set.put(first_element,i);
        }
        return new int[]{-1,-1};
    }
}