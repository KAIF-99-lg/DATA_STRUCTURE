class Trie {

    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWords = false;
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
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
        TrieNode node = root;
        for(char ch:word.toCharArray()){
            int idx = ch - 'a';
            if(node.children[idx] == null){
                return false;
            }
            node = node.children[idx];
        }
        return node.isEndOfWords;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch:prefix.toCharArray()){
            int idx = ch - 'a';
            if(node.children[idx] == null){
                return false;
            }
            node = node.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */