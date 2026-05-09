# 944. Delete Columns to Make Sorted

## Problem Statement

You are given an array of strings `strs` where all strings have the same length.

You need to delete the columns that are not sorted lexicographically from top to bottom.

Return the number of columns that must be deleted.

---

## Example

### Input

```java id="2i7b0k"
strs = ["cba","daf","ghi"]
```

### Output

```java id="q5l9em"
1
```

### Explanation

Grid representation:

```text id="6o7k1s"
c b a
d a f
g h i
```

* Column 0 → `c, d, g` ✅ Sorted
* Column 1 → `b, a, h` ❌ Not Sorted
* Column 2 → `a, f, i` ✅ Sorted

So, only 1 column needs to be deleted.

---

# Java Solution

```java id="m0v9hx"
class Solution {

    public int minDeletionSize(String[] strs) {

        int rows = strs.length;
        int cols = strs[0].length();

        int deleteCount = 0;

        // Traverse each column
        for (int col = 0; col < cols; col++) {

            // Check if current column is sorted
            for (int row = 1; row < rows; row++) {

                if (strs[row].charAt(col) < strs[row - 1].charAt(col)) {
                    deleteCount++;
                    break;
                }
            }
        }

        return deleteCount;
    }
}
```

---

# Approach

1. Traverse each column one by one.
2. Compare characters vertically.
3. If any character is smaller than the previous row character:

   * Increment delete count.
   * Stop checking that column.

---

# Complexity Analysis

### Time Complexity

```text id="o2q1na"
O(n × m)
```

* `n` = number of strings
* `m` = length of each string

### Space Complexity

```text id="f3l7yd"
O(1)
```

---

⭐ If you found this solution helpful, consider starring the repository.
