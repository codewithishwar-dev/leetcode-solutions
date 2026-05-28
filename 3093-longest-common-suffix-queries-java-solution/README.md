# 3093. Longest Common Suffix Queries

## Problem Link

https://leetcode.com/problems/longest-common-suffix-queries/

## Difficulty

Hard

## Topics

* Trie
* Strings
* Prefix Tree

---

# Approach: Reverse Trie

Since we need to find the **longest common suffix**, we can reverse all strings and convert the problem into a **longest common prefix** problem.

### Example

```text
"abcd" -> "dcba"
"cd"   -> "dc"
```

Now suffix matching becomes prefix matching.

We build a Trie using reversed `wordsContainer`.

Each Trie node stores:

* the best index for that suffix
* priority rules:

  1. smaller string length
  2. if tie → smaller index

For every query:

* traverse the reversed query string
* continue while matching characters exist
* deepest matched node gives the answer

---

# Time Complexity

### Building Trie

```text
O(sum of wordsContainer lengths)
```

### Query Processing

```text
O(sum of wordsQuery lengths)
```

### Overall

```text
O(total characters)
```

---

# Java Solution

```java
class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        int bestIdx = -1;
    }

    TrieNode root = new TrieNode();
    String[] words;

    // Choose better index:
    // 1. smaller length
    // 2. if tie -> smaller index
    private int better(int a, int b) {
        if (a == -1) return b;
        if (b == -1) return a;

        if (words[a].length() != words[b].length()) {
            return words[a].length() < words[b].length() ? a : b;
        }

        return Math.min(a, b);
    }

    private void insert(String s, int idx) {
        TrieNode node = root;

        // update root
        node.bestIdx = better(node.bestIdx, idx);

        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';

            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }

            node = node.child[c];

            node.bestIdx = better(node.bestIdx, idx);
        }
    }

    private int query(String s) {
        TrieNode node = root;

        int ans = node.bestIdx;

        for (int i = s.length() - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';

            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];
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

        int[] ans = new int[wordsQuery.length];

        // Process Queries
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = query(wordsQuery[i]);
        }

        return ans;
    }
}
```

---

# Example Walkthrough

## Input

```text
wordsContainer = ["abcd","bcd","xbcd"]
wordsQuery = ["cd","bcd","xyz"]
```

## Reversed Words

```text
dcba
dcb
dcbx
```

## Query = "cd"

Reversed:

```text
dc
```

Trie traversal:

```text
d -> c
```

Matching suffix:

```text
"cd"
```

Candidate indices:

```text
0, 1, 2
```

Shortest word:

```text
"bcd" -> index 1
```

Output:

```text
1
```

---

# Key Insight

* Reversing strings converts suffix matching into prefix matching.
* Trie depth naturally represents suffix length.
* Each node stores the best possible answer for that suffix.

This makes queries extremely efficient.

---

# Tags

```text
Trie
String
Prefix Tree
LeetCode Hard
```
