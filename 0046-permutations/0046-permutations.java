class Solution {
    public void findPermutations(int idx,int[]nums,List<List<Integer>> result){
        if(idx == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                ds.add(nums[i]);
            }
            result.add(new ArrayList<>(ds));
            return;
        }

        for(int i = idx;i<nums.length;i++){
            swap(i,idx,nums);
            findPermutations(idx+1,nums,result);
            swap(i,idx,nums);
        }
    }

    public void swap(int i,int j,int[]nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPermutations(0,nums,result);
        return result;
    }
}