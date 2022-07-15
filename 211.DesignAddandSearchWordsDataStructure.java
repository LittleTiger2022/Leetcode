// s1: this solution met TLE
// it uses ArrayList
class WordDictionary {
    List<String> words = new ArrayList<String>();
    public WordDictionary() {
        
        
    }
    
    public void addWord(String word) {
        words.add(word);
    }
    
    public boolean search(String word) {
        for (String temp:words) {
            if (temp.equals(word))
                return true;
        }
        // else
        for (String temp:words) {
                boolean doesDotExit = false;
                for (int i=0;i<word.length();i++)
                    if (word.charAt(i)=='.')
                        doesDotExit = true;
                
                if (doesDotExit==false)
                    break;
                else if (temp.length()==word.length()) {
                    boolean tempMatch = true;
                    for (int j=0;j<word.length();j++) {
                        if (temp.charAt(j)==word.charAt(j) || word.charAt(j)=='.')
                            tempMatch = tempMatch & true;
                        else
                            tempMatch = false;
                    }
                    if (tempMatch==true)
                        return true;
                }
            }
                return false;

    }
}

// s2: use TrieNode
// 822 ms. 75%, 35.6%
class WordDictionary {
            TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur = root;
        for (char c: word.toCharArray()) {
            if (cur.children[c-'a']==null)
                cur.children[c-'a'] = new TrieNode();
            cur = cur.children[c-'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word.toCharArray(),0,root);
    }
    
    boolean searchHelper(char [] cs, int i, TrieNode root) {
        if (i==cs.length)
            return root.isWord;
        if (cs[i]=='.') {
            for (TrieNode child : root.children)
                if (child!=null)
                    if (searchHelper(cs,i+1,child))
                        return true;
        } else
            return root.children[cs[i]-'a'] != null && searchHelper(cs,i+1,root.children[cs[i]-'a']);
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
class TrieNode {
        boolean isWord;
        TrieNode [] children;
     
        public TrieNode() {
            this.isWord = false;
            children = new TrieNode[26];
        }
    }
    
