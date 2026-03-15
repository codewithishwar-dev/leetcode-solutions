# 14. Longest Common Prefix

## Problem

Write a function to find the **longest common prefix string** amongst an array of strings.

If there is no common prefix, return an empty string `""`.

---

## Example 1

Input

["flower","flow","flight"]

Output

"fl"

---

## Example 2

Input

["dog","racecar","car"]

Output

""

---

## Approach

### Vertical Scanning

1. Take the first string as reference.
2. Compare characters column by column with all other strings.
3. If a mismatch is found, return the prefix up to that index.

Example:

flower  
flow  
flight  

Compare characters:

f = f = f ✔  
l = l = l ✔  
o = o ≠ i ❌  

Result → **"fl"**

---

## Complexity Analysis

**Time Complexity**

O(S)

Where S is the total number of characters in all strings.

**Space Complexity**

O(1)

No extra space is used.

---

## Java Solution

```java
class Solution {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {

            char currentChar = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {

                if (i == strs[j].length() || strs[j].charAt(i) != currentChar) {
                    return strs[0].substring(0, i);
                }

            }
        }

        return strs[0];
    }
}
