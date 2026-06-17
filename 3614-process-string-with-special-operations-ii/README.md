# 3614. Process String with Special Operations II

## Problem

You are given a string `s` consisting of lowercase English letters and special characters `'*'`, `'#'`, and `'%'`.

Process the string from left to right:

* Lowercase letter → append to the result.
* `'*'` → remove the last character from the result (if any).
* `'#'` → duplicate the current result and append it to itself.
* `'%'` → reverse the current result.

Return the character at index `k` in the final result string. If `k` is out of bounds, return `'.'`.

---

## Approach

The final string length can grow up to `10^15`, making it impossible to construct the string directly.

### Key Observation

Instead of building the string, track only the length after each operation.

### Forward Pass

Store the length of the resulting string after processing each character:

* Letter → `length + 1`
* `*` → `max(0, length - 1)`
* `#` → `length * 2`
* `%` → length remains unchanged

### Reverse Traversal

Starting from the final index `k`, walk through the operations in reverse and map the index back to its origin:

#### Letter (`a-z`)

If `k == previousLength`, the current letter created this position, so return it.

#### `*`

Forward operation removed the last character.
Any surviving index remains unchanged while moving backward.

#### `#`

Forward operation duplicated the string:

```text
abc -> abcabc
```

Backward mapping:

```text
k = k % previousLength
```

#### `%`

Forward operation reversed the string:

```text
abc -> cba
```

Backward mapping:

```text
k = previousLength - 1 - k
```

Continue until the character responsible for index `k` is found.

---

## Algorithm

1. Compute the length after every operation.
2. If `k` is outside the final length, return `'.'`.
3. Traverse the operations from right to left.
4. Reverse-map `k` according to the operation:

   * Letter → check if it generated index `k`
   * `*` → unchanged
   * `#` → `k %= previousLength`
   * `%` → `k = previousLength - 1 - k`
5. Return the discovered character.

---

## Complexity Analysis

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)`

where `n` is the length of `s`.

---

## Java Solution

```java
class Solution {
    public char processStr(String s, long k) {
        int n = s.length();

        long[] len = new long[n + 1];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                len[i + 1] = len[i] + 1;
            } else if (ch == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } else if (ch == '#') {
                len[i + 1] = len[i] * 2;
            } else { // '%'
                len[i + 1] = len[i];
            }
        }

        long finalLength = len[n];

        if (k < 0 || k >= finalLength) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long prevLen = len[i];

            if (ch >= 'a' && ch <= 'z') {
                if (k == prevLen) {
                    return ch;
                }
            } else if (ch == '*') {
                // index remains unchanged
            } else if (ch == '#') {
                if (prevLen > 0) {
                    k %= prevLen;
                }
            } else { // '%'
                k = prevLen - 1 - k;
            }
        }

        return '.';
    }
}
```
