class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int len=s.length();
        int maxLen=0;

        for(int mid=0;mid<len;mid++){
            int i = mid - 1;
            int j = mid + 1;
            int currLen = 1;
            
            while(i>=0 && j<len && s.charAt(i)==s.charAt(j)){
                i--;
                j++;
                currLen+=2;
            }
            if(maxLen<currLen){
                ans=s.substring(i+1,j);
                maxLen=currLen;
            }
        }

        for(int mid=0;mid<len-1;mid++){
            int i = mid;
            int j = mid + 1;
            int currLen = 0;

            while(i>=0 && j<len && s.charAt(i)==s.charAt(j)){
                i--;
                j++;
                currLen+=2;
            }
            if(maxLen<currLen){
                ans=s.substring(i+1,j);
                maxLen=currLen;;
            }
        }
        return ans;
    }
}