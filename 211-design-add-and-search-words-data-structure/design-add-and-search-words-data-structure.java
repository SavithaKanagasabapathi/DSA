class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    //TC-O(L) and SC-O(L*N), L-length and N-No. of words
    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.isEndOfWord = true;
    }

    //No dots - TC-O(L) and SC-O(L) as recursion stack
    //With dots - TC-O(26^L) and SC-O(L) as recursion stack, only in worst case, if word is full of .
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode current) {
        if (index >= word.length()) {
            return current.isEndOfWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            return IntStream.range(0, 26).filter(i -> current.children[i] != null)
                    .anyMatch(i -> dfs(word, index + 1, current.children[i]));
        } else {
            TrieNode child = current.children[c - 'a'];
            if (child != null) {
                return dfs(word, index + 1, current.children[c - 'a']);
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */