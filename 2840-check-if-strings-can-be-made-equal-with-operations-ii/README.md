# 2840. Check if Strings Can be Made Equal With Operations II

## 🧩 Problem
You are given two strings `s1` and `s2` of equal length.

You can perform an operation:
- Choose indices `i < j` such that `(j - i)` is even
- Swap characters at those indices

Return `true` if `s1` can be made equal to `s2`, else `false`.

---

## 💡 Key Insight

You can only swap characters where `(j - i)` is even.

👉 This means:
- Even indices can swap only with even indices
- Odd indices can swap only with odd indices

So, the string splits into **two independent groups**:
- Even index characters
- Odd index characters

---

## ✅ Approach

1. Count frequency of characters at:
   - Even indices
   - Odd indices

2. Do this for both strings

3. Compare:
   - Even frequencies must match
   - Odd frequencies must match

---

## 🚀 Code (Java)

```java
class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] even1 = new int[26];
        int[] odd1 = new int[26];
        int[] even2 = new int[26];
        int[] odd2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (i % 2 == 0) {
                even1[c1 - 'a']++;
                even2[c2 - 'a']++;
            } else {
                odd1[c1 - 'a']++;
                odd2[c2 - 'a']++;
            }
        }

        return Arrays.equals(even1, even2) && Arrays.equals(odd1, odd2);
    }
}
```

⏱ Complexity
Time: O(n)
Space: O(1)
🧠 Intuition

Think of indices as two separate buckets:

You can freely rearrange inside each bucket
But cannot move elements across buckets
🔥 Example
Input
s1 = "abcdba"
s2 = "cabdab"
Output
true
📌 Tags
Strings
Hashing
Greedy
Parity
Frequency Count
✨ Author

Ishwar | codewithishwar
