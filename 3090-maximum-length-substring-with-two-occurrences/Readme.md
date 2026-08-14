# 3090. Maximum Length Substring With Two Occurrences

**Difficulty:** Easy
**Topics:** String, Hash Table, Sliding Window, Frequency Counting

## Problem Statement

Given a string `s`, return the **maximum length of a substring** such that it contains **at most two occurrences of each character**.

A substring must be contiguous.

### Example 1

**Input:**

```text
s = "bcbbbcba"
```

**Output:**

```text
4
```

**Explanation:**

The longest valid substring has length `4`.

For example:

```text
"bcbb"
```

Character frequencies:

```text
b → 3
c → 1
```

However, this contains three `b`s and is therefore invalid.

A valid substring of length `4` is:

```text
"cbbb"
```

Actually, this also contains three `b`s and is invalid.

The valid maximum-length window is:

```text
"bcba"
```

Character frequencies:

```text
b → 2
c → 1
a → 1
```

Therefore, the answer is:

```text
4
```

### Example 2

**Input:**

```text
s = "aaaa"
```

**Output:**

```text
2
```

**Explanation:**

Only two occurrences of `a` are allowed.

Therefore:

```text
"aa"
```

is the longest valid substring.

---

# Approach

## Sliding Window

This problem can be efficiently solved using the **Sliding Window** technique.

The key observation is:

> We need the longest contiguous substring where the frequency of every character is at most `2`.

We maintain a window:

```text
[left ... right]
```

and keep track of the frequency of each character inside this window.

### Window Expansion

Move `right` from left to right and add the current character to the window.

For example:

```text
s = "bcbbbcba"

         right
           ↓
b c b b
```

We maintain the frequency of each character.

If every character appears at most twice, the window is valid.

---

## When the Window Becomes Invalid

Suppose adding a character causes its frequency to become greater than `2`.

For example:

```text
b c b b
```

If another `b` is added:

```text
b c b b b
```

Frequency becomes:

```text
b → 3
c → 1
```

The window is now invalid because `b` occurs more than twice.

To fix this, move `left` forward and remove characters from the window until the frequency constraint is satisfied again.

```text
b c b b b
↑
left
```

Remove the first `b`:

```text
  c b b b
  ↑
 left
```

Now:

```text
b → 3
```

is still invalid, so continue shrinking.

After removing another `b`:

```text
    b b
```

Now:

```text
b → 2
```

and the window becomes valid again.

---

# Algorithm

1. Create a frequency array of size `26` because the string contains only lowercase English letters.
2. Initialize:

   * `left = 0`
   * `maxLength = 0`
3. Iterate through the string using `right`.
4. Increment the frequency of `s[right]`.
5. If the frequency of the current character becomes greater than `2`, move `left` forward.
6. Decrease the frequency of every character removed from the window.
7. Continue shrinking until the window becomes valid.
8. Calculate the current window length:

```text
right - left + 1
```

9. Update `maxLength`.
10. Return `maxLength`.

---

# Java Implementation

```java
class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;

            while (freq[s.charAt(right) - 'a'] > 2) {
                freq[s.charAt(left) - 'a']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
```

---

# Detailed Dry Run

Consider:

```text
s = "bcbbbcba"
```

We maintain:

```text
left = 0
maxLength = 0
```

### Step 1

Character:

```text
b
```

Window:

```text
"b"
```

Frequency:

```text
b → 1
```

Valid.

Length:

```text
1
```

Maximum:

```text
1
```

---

### Step 2

Character:

```text
c
```

Window:

```text
"bc"
```

Frequency:

```text
b → 1
c → 1
```

Valid.

Length:

```text
2
```

Maximum:

```text
2
```

---

### Step 3

Character:

```text
b
```

Window:

```text
"bcb"
```

Frequency:

```text
b → 2
c → 1
```

Valid.

Length:

```text
3
```

Maximum:

```text
3
```

---

### Step 4

Character:

```text
b
```

Window:

```text
"bcbb"
```

Frequency:

```text
b → 3
c → 1
```

Invalid because `b` occurs 3 times.

Move `left` forward.

Remove:

```text
b
```

New window:

```text
"cbb"
```

Frequency:

```text
b → 2
c → 1
```

Valid.

Length:

```text
3
```

---

### Step 5

Continue expanding the window.

When another `b` causes the frequency to exceed `2`, the left side of the window is moved forward again until the frequency constraint is restored.

The important property is that the window always remains valid after the `while` loop.

---

# Why Sliding Window Works

A brute-force approach would generate every possible substring and count character frequencies.

There can be `O(n²)` substrings, making this approach inefficient.

Instead, the Sliding Window approach maintains a valid substring dynamically.

When we expand the window:

```text
right++
```

we only need to check whether the constraint has been violated.

If it is violated, we shrink:

```text
left++
```

until the window becomes valid again.

This avoids repeatedly scanning the same substring.

---

# Correctness Intuition

At every iteration:

```text
[left ... right]
```

represents the longest valid window ending at `right`.

If adding `s[right]` makes the window invalid, we move `left` forward until every character occurs at most twice.

Therefore, after the `while` loop:

```text
freq[character] <= 2
```

for every character in the current window.

We then compare its length with the best answer found so far.

Since every possible right endpoint is considered and the window is maximized for that endpoint, the overall maximum valid substring length is found.

---

# Complexity Analysis

Let `n` be the length of the string.

## Time Complexity

```text
O(n)
```

Although there is a nested `while` loop, each character enters the window once and leaves the window at most once.

Therefore:

```text
right → moves n times
left  → moves at most n times
```

Overall:

```text
O(n)
```

## Space Complexity

```text
O(1)
```

The frequency array contains only `26` entries:

```text
int[26]
```

Since the alphabet is fixed, the space complexity is constant.

---

# Alternative Approach

A `HashMap<Character, Integer>` can also be used.

For example:

```java
Map<Character, Integer> frequency = new HashMap<>();
```

This is useful when the input can contain a larger or unknown character set.

However, because the problem explicitly states:

```text
s consists only of lowercase English letters
```

an array of size `26` is simpler and slightly more efficient.

---

# Common Mistakes

## 1. Using a Set

A `Set` only tells us whether a character exists.

It cannot distinguish:

```text
b → 1
```

from:

```text
b → 2
```

or:

```text
b → 3
```

We need actual frequencies, so a frequency array or map is required.

---

## 2. Shrinking Only Once

When a character exceeds the allowed frequency, we cannot always move `left` only once.

For example, if a character occurs several times, multiple characters may need to be removed.

That's why we use:

```java
while (freq[s.charAt(right) - 'a'] > 2) {
    freq[s.charAt(left) - 'a']--;
    left++;
}
```

rather than:

```java
if (...)
```

---

## 3. Calculating Window Length Incorrectly

The length of a window from `left` to `right` is:

```text
right - left + 1
```

The `+1` is important because both endpoints are included.

---

# Interview Explanation

A concise explanation for an interview:

> "I would solve this using a sliding window. I maintain two pointers, `left` and `right`, and a frequency array for the 26 lowercase characters. I expand the right pointer and increment the character frequency. If any character occurs more than twice, I move the left pointer forward while decrementing frequencies until the window becomes valid again. After each valid window, I update the maximum length. Since each character enters and leaves the window at most once, the time complexity is O(n) and the space complexity is O(1)."

---

# Pattern Recognition

This problem belongs to the following DSA pattern:

```text
Substring
    ↓
Frequency Constraint
    ↓
At Most K Occurrences
    ↓
Sliding Window
    ↓
Frequency Array / HashMap
```

### General Template

For problems like:

> Find the longest substring where each character appears at most `K` times.

The general approach is:

```java
int left = 0;
int maxLength = 0;

for (int right = 0; right < s.length(); right++) {

    // Add current character
    freq[s.charAt(right) - 'a']++;

    // Restore validity
    while (freq[s.charAt(right) - 'a'] > K) {
        freq[s.charAt(left) - 'a']--;
        left++;
    }

    // Update answer
    maxLength = Math.max(maxLength, right - left + 1);
}
```

For this problem:

```text
K = 2
```

---

# Key Takeaways

* Use **Sliding Window** for contiguous substring constraints.
* Use a **frequency array** when the character set is fixed and small.
* Expand the window using `right`.
* Shrink the window using `left`.
* Use `while` when multiple elements may need to be removed.
* The window remains valid after the shrinking step.
* Each element is processed at most twice.
* Overall complexity is **O(n) time and O(1) space**.

---

# Related DSA Pattern

This problem is closely related to:

* Longest substring with at most `K` distinct characters
* Longest substring without repeating characters
* Longest substring with character frequency constraints
* Minimum window substring
* Permutation/anagram sliding-window problems

---

## LeetCode

[3090. Maximum Length Substring With Two Occurrences](https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/)

**Tags:** `String` `Hash Table` `Sliding Window` `Frequency Counting`
