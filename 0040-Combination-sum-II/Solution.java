class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombination(0,candidates,target,result,new ArrayList<>());
        return result;
    }

    public void findCombination(int index,int[]candidates,int target,List<List<Integer>> result,List<Integer> ds){
        if(target==0){
            result.add(new ArrayList<>(ds));
            return;
        }  
        for(int i=index;i<candidates.length;i++){

            if(i>index && candidates[i]==candidates[i-1]) continue;
            if(candidates[i] > target) break;
            ds.add(candidates[i]);
            findCombination(i+1,candidates,target-candidates[i],result,ds);
            ds.remove(ds.size()-1);
        }
    }
}