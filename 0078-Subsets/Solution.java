class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0,nums,result,new ArrayList<>());
        return result;
    }


    public void generateSubsets(int idx,int[]nums,List<List<Integer>> result,List<Integer> ds){
        result.add(new ArrayList<>(ds));

        for(int i=idx;i<nums.length;i++){
            ds.add(nums[i]);
            generateSubsets(i+1,nums,result,ds);
            ds.remove(ds.size()-1);
        }
    }
}