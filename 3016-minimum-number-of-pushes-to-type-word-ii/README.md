# 3016. Minimum Number of Pushes to Type Word II

**Difficulty:** Medium
**Topics:** Greedy, Hash Table, Sorting, Counting

## Problem

Given a string `word` containing lowercase English letters, we can remap the letters to telephone keys numbered `2` to `9`.

There are **8 available keys**.

For each key:

* First assigned letter requires **1 push**
* Second assigned letter requires **2 pushes**
* Third assigned letter requires **3 pushes**
* Fourth assigned letter requires **4 pushes**

The goal is to remap the letters so that the total number of pushes required to type `word` is minimized.

## Key Observation

Unlike **3014. Minimum Number of Pushes to Type Word I**, characters in this problem can repeat.

Therefore, the **frequency of each character matters**.

A frequently occurring character should require fewer pushes than a rarely occurring character.

Since there are 8 keys:

```text
Top 8 most frequent characters     → 1 push
Next 8 most frequent characters    → 2 pushes
Next 8 most frequent characters    → 3 pushes
Remaining characters               → 4 pushes
```

This leads naturally to a greedy approach.

## Approach

1. Count the frequency of each character.
2. Sort the 26 frequencies.
3. Process them from highest to lowest.
4. Assign the most frequent 8 characters a cost of `1`.
5. Assign the next 8 a cost of `2`.
6. Continue until all used characters are assigned.

For a character at position `i` after sorting by decreasing frequency:

```text
cost = (i / 8) + 1
```

Then:

```text
totalPushes += frequency × cost
```

## Example

```text
word = "aabbccddeeffgghhiiiiii"
```

Frequencies:

```text
i = 6

a = 2
b = 2
c = 2
d = 2
e = 2
f = 2
g = 2
h = 2
```

Sorted frequencies:

```text
6, 2, 2, 2, 2, 2, 2, 2, 2
```

The first 8 characters require one push:

```text
6 × 1 + 2 × 1 + 2 × 1 + 2 × 1
      + 2 × 1 + 2 × 1 + 2 × 1 + 2 × 1
= 20
```

The 9th character requires two pushes:

```text
2 × 2 = 4
```

Therefore:

```text
Total = 20 + 4 = 24
```

## Java Solution

```java
import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        // Count character frequencies
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Sort frequencies
        Arrays.sort(freq);

        int pushes = 0;
        int position = 0;

        // Process highest frequencies first
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) {
                break;
            }

            int cost = (position / 8) + 1;

            pushes += freq[i] * cost;
            position++;
        }

        return pushes;
    }
}
```

## Complexity Analysis

### Time Complexity

```text
O(n)
```

Counting the characters takes `O(n)`.

Sorting only 26 elements takes `O(26 log 26)`, which is effectively constant.

Overall:

```text
O(n)
```

### Space Complexity

```text
O(1)
```

The frequency array always contains exactly 26 elements.

## Pattern

**Frequency Counting + Sorting + Greedy**

The important greedy idea is:

> Assign the most frequently used characters to the cheapest keypad positions.

## Takeaway

When assignment positions have different costs and some elements occur more frequently than others, minimize the total cost by assigning the **highest-frequency elements to the lowest-cost positions**.
