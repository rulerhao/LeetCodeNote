class WordDictionary {

    class Node {
        Node[] children;
        char val;
        boolean isWord;
        public Node(char c) {
            val = c;
            children = new Node[26];
            isWord = false;
        }
    }
    
    Node node;
    
    public WordDictionary() {
        node = new Node('\0');
    }
    
    public void addWord(String word) {
        Node cur = node;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node(c);
            } else {
                
            }
            cur = cur.children[c - 'a'];
        }
        
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        return searchImp(word, node, 0);
    }
    
    private boolean searchImp(String word, Node cur, int index) {
        if (index == word.length()) return cur.isWord;
        
        char c = word.charAt(index);
        if (c == '.') {
            boolean res;
            for (Node child: cur.children) {
                if (child != null) {
                    res = searchImp(word, child, index + 1);
                    if (res) return true;
                }
            }
            return false;
        } else if (cur.children[c - 'a'] != null) {
            Node next = cur.children[c - 'a'];
            return searchImp(word, next, index + 1);
        }
        
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
