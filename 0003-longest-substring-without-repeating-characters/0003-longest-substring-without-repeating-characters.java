class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxlen = 0;

        int n = s.length();

        while(right<n){
            char ch = s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxlen = Math.max(maxlen,(right-left+1));
            right++;
        }
        return maxlen;
    }
}