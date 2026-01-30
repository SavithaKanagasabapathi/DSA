class Solution {
    //TC-O(N.M.3^L) - N*M cells, 3 directions (excluding where we came from), L max length of words
    //SC-O(E(word lengths)) - Summation of all words length stored in trie and recursion
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;
        TrieNode root = buildTrie(words);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {//check every cell for it's first word
                findWord(board, root, i, j, result);
            }
        }
        return result;
    }

    private void findWord(char[][] board, TrieNode node, int row, int col, List<String> result) {
        if (row >= 0 && row < board.length && col >= 0 && col < board[0].length
                && board[row][col] != '#' && node.children[board[row][col] - 'a'] != null) {

            node = node.children[board[row][col] - 'a'];//set to node
            if (node.word != null) {
                result.add(node.word);//add in result
                node.word = null;//set null to avoid confusion
            }

            char temp = board[row][col];
            board[row][col] = '#';//marked

            //next step, go all directions
            findWord(board, node, row + 1, col, result);
            findWord(board, node, row - 1, col, result);
            findWord(board, node, row, col + 1, result);
            findWord(board, node, row, col - 1, result);

            board[row][col] = temp;//backtrack
        }
        return;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode current = root;//this line inside for as all words start should be in root
            for (char c : word.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                }
                current = current.children[c - 'a'];//this line should be out of above condition
            }
            current.word = word;
        }
        return root;
    }
}