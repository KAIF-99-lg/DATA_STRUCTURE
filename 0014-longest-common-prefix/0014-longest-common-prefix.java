class Solution {
    public String longestCommonPrefix(String[] strs) {
        int idx = 0;
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length-1];

        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)==str2.charAt(i)){
                idx++;
            }else{
                break;
            }
        }

        return str1.substring(0,idx);
    }
}