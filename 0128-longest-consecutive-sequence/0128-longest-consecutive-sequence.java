class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen=0;
        Set<Integer> set= new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        for(int elem:set){
           
            if(!set.contains(elem-1)){
                int len=1;
                while(set.contains(elem+len)){
                    len++;
                }
                maxLen=Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
}