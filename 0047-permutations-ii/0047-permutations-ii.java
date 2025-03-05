class Solution {
    public void uniquePermute(int idx,int[] nums,List<List<Integer>> result) {
        if(idx == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            result.add(new ArrayList<>(ds));
            return;
        }
        Set<Integer> swapped = new HashSet<>();
        for(int i = idx;i<nums.length;i++){
            if (swapped.contains(nums[i])) continue;
            swapped.add(nums[i]);
            
            swap(i,idx,nums);
            uniquePermute(idx+1,nums,result);
            swap(i,idx,nums);
        }
    }

    public void swap(int i,int j,int[]nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        uniquePermute(0,nums,result);
        return result;
    }
}