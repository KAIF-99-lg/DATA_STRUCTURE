class WordDictionary {

     private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWords = false;
    }

    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch:word.toCharArray()){
            int idx = ch - 'a';
            if(node.children[idx] == null){
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWords = true;
    }
    
    public boolean search(String word) {
        return searchForm(word,0,root);
    }

    public boolean searchForm(String word,int index,TrieNode node){
        if(node == null) return false;
        if(index == word.length()) return node.isEndOfWords;

        char ch = word.charAt(index);
        if(ch == '.'){
            for(TrieNode child:node.children){
                if(child != null && searchForm(word,index+1,child)){
                    return true;
                }
            }
            return false;
        }else{
            if(ch < 'a' || ch > 'z') return false;
            int idx = ch - 'a';
            return searchForm(word,index+1,node.children[idx]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */