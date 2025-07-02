class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length==0){
            return new ArrayList<>();
        }

        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            String freqStr = getFreqStr(str);
            if(map.containsKey(freqStr)){
                map.get(freqStr).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(freqStr,list);
            }
        }

        return new ArrayList<>(map.values());
    }

    public String  getFreqStr(String str){
        int freq[] = new int[26];
        for(char c : str.toCharArray()){
            freq[c-'a']++;
        }

        StringBuilder sb = new StringBuilder("");
        char c = 'a';
        for(int i:freq){
            sb.append(c);
            sb.append(i);
            c++;
        }

        return sb.toString();
    }
}