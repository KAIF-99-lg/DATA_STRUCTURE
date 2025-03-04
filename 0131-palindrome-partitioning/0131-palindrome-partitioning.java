class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        findPartition(0,s,result,ds);
        return result;
    }


    public void  findPartition(int idx,String s,List<List<String>> result,List<String> ds){
        if(idx == s.length()){
            result.add(new ArrayList<>(ds));
            return;
        }

        for(int i = idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                ds.add(s.substring(idx,(i+1)));
                findPartition(i+1,s,result,ds);
                ds.remove(ds.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}