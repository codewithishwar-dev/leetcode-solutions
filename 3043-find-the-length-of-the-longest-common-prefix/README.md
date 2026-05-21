# 3043. Find the Length of the Longest Common Prefix

## Problem Statement

You are given two arrays with positive integers `arr1` and `arr2`.

A prefix of a positive integer is an integer formed by one or more of its digits, starting from its leftmost digit.

Return the length of the longest common prefix among all pairs `(x, y)` where `x` belongs to `arr1` and `y` belongs to `arr2`.

---

## Example 1

Input:
```text
arr1 = [1,10,100]
arr2 = [1000]
```

Output:
```text
3
```

Explanation:

- Longest common prefix of (1, 1000) = 1
- Longest common prefix of (10, 1000) = 10
- Longest common prefix of (100, 1000) = 100

The longest common prefix is `100`, whose length is `3`.

---

## Example 2

Input:
```text
arr1 = [1,2,3]
arr2 = [4,4,4]
```

Output:
```text
0
```

---

## Approach

Store every possible prefix of numbers in `arr1` inside a HashSet.

For each number in `arr2`:

1. Check whether the entire number exists as a prefix.
2. If not, remove the last digit repeatedly.
3. Once a matching prefix is found, update the maximum prefix length.

Since every number contains at most 9 digits, the number of generated prefixes is limited, making the solution efficient.

---

## Algorithm

1. Create a HashSet to store prefixes from `arr1`.
2. For every number in `arr1`:
   - Add the number.
   - Remove the last digit repeatedly and add all prefixes.
3. For every number in `arr2`:
   - Check prefixes from longest to shortest.
   - If found in the HashSet, update the answer.
4. Return the maximum length found.

---

## Complexity Analysis

- Time Complexity: **O((n + m) × d)**
  - `d` = number of digits (maximum 9)
- Space Complexity: **O(n × d)**

---

## Java Solution

```java
import java.util.*;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();

        for (int num : arr1) {
            int x = num;
            while (x > 0) {
                prefixes.add(x);
                x /= 10;
            }
        }

        int ans = 0;

        for (int num : arr2) {
            int x = num;
            while (x > 0) {
                if (prefixes.contains(x)) {
                    ans = Math.max(ans, String.valueOf(x).length());
                    break;
                }
                x /= 10;
            }
        }

        return ans;
    }
}
```

## Tags

- Hash Table
- String
- Prefix Matching
- Trie
