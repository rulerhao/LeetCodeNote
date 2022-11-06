class Solution {
    List<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0) return new LinkedList<>();

        res = new LinkedList<>();
        
        Tree root = new Tree();
        for (String word: words) {
            Tree tmp = root;
            for (int i = 0; i < word.length(); i++) {
                if (tmp.sons[word.charAt(i) - 'a'] == null) {
                    tmp.sons[word.charAt(i) - 'a'] = new Tree();
                    tmp.sons[word.charAt(i) - 'a'].parent = tmp;
                }
                tmp = tmp.sons[word.charAt(i) - 'a'];
            }
            tmp.word = word;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                searchWords(root.sons[val - 'a'], board[i][j], "", j, i);
            }
        }

        return res;
    }

    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void searchWords(Tree root, char[][] board, String str, int x, int y) {
        if (root == null) return;
        if (x < 0 || y < 0 || x > board[0].length - 1 || y > board.length - 1) return;
        char val = board[y][x];
        if (val == '0') return;
        str = str + val;
        if (root.word != null && str.equals(root.word)) {
            res.add(root.word);
            root.word = null;
        }

        board[y][x] = '0';
        
        for (int i = 0; i < dirs.length; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];
            if (newX < 0 || newY < 0 || newX > board[0].length - 1 || newY > board.length - 1) continue;
            char newVal = board[newY][newX];
            if (newVal == '0') continue;
            searchWords(root.sons[newVal - 'a'], board, str, newX, newY);
        }

        board[y][x] = val;
    }

    private class Tree {
        private Tree[] sons;
        private Tree parent;
        private String word;
        private Tree() {
            this.sons = new Tree[26];
        }
    }
}
