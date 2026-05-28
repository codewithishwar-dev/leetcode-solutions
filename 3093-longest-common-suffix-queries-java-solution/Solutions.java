class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int bestIdx = -1;
    }

    private final TrieNode root = new TrieNode();
    private String[] words;

    // Returns the better index based on:
    // 1. Smaller word length
    // 2. Smaller index if lengths are equal
    private int better(int a, int b) {
        if (a == -1) return b;
        if (b == -1) return a;

        if (words[a].length() != words[b].length()) {
            return words[a].length() < words[b].length() ? a : b;
        }

        return Math.min(a, b);
    }

    private void insert(String word, int idx) {
        TrieNode node = root;

        // Update root answer
        node.bestIdx = better(node.bestIdx, idx);

        for (int i = word.length() - 1; i >= 0; i--) {
            int ch = word.charAt(i) - 'a';

            if (node.child[ch] == null) {
                node.child[ch] = new TrieNode();
            }

            node = node.child[ch];

            // Store best answer at every node
            node.bestIdx = better(node.bestIdx, idx);
        }
    }

    private int search(String query) {
        TrieNode node = root;

        int ans = node.bestIdx;

        for (int i = query.length() - 1; i >= 0; i--) {
            int ch = query.charAt(i) - 'a';

            if (node.child[ch] == null) {
                break;
            }

            node = node.child[ch];
            ans = node.bestIdx;
        }

        return ans;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        words = wordsContainer;

        // Build Trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] result = new int[wordsQuery.length];

        // Process Queries
        for (int i = 0; i < wordsQuery.length; i++) {
            result[i] = search(wordsQuery[i]);
        }

        return result;
    }
}
