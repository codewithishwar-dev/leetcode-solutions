# 2913. Subarrays Distinct Element Sum of Squares I

**Difficulty:** Easy  
**Topics:** Array, Hashing, Brute Force  
**Language:** Java

## Problem Statement

Given a 0-indexed integer list `nums`, calculate the sum of the squares of the distinct element counts of every non-empty contiguous subarray.

The distinct count of a subarray is the number of unique elements it contains.

### Example 1

**Input**
```text
nums = [1, 2, 1]
```

**Output**
```text
15
```

**Explanation**

The subarrays and their squared distinct counts are:

| Subarray | Distinct Count | Square |
|---|---:|---:|
| [1] | 1 | 1 |
| [1, 2] | 2 | 4 |
| [1, 2, 1] | 2 | 4 |
| [2] | 1 | 1 |
| [2, 1] | 2 | 4 |
| [1] | 1 | 1 |

Total = 1 + 4 + 4 + 1 + 4 + 1 = **15**.

### Approach: Brute Force

1. Iterate through every possible starting index.
2. Create a boolean array to track elements already encountered in the current subarray.
3. Extend the subarray one element at a time.
4. Increment the distinct count whenever a new element appears.
5. Add the square of the distinct count to the result for each subarray.

### Java Solution

```java
import java.util.*;

class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int result = 0;

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[101];
            int distinctCount = 0;

            for (int j = i; j < n; j++) {
                int num = nums.get(j);

                if (!seen[num]) {
                    seen[num] = true;
                    distinctCount++;
                }

                result += distinctCount * distinctCount;
            }
        }

        return result;
    }
}
```

### Complexity Analysis

- **Time Complexity:** O(n²), since every subarray is considered.
- **Auxiliary Space Complexity:** O(1), since the boolean array has a fixed size of 101.

### Key Takeaway

This problem demonstrates how to enumerate subarrays efficiently while maintaining the distinct element count incrementally, avoiding repeated calculations for each subarray.

---

**#CodeWithIshwar #LeetCode #Java #DSA #ProblemSolving #CodingPractice**
