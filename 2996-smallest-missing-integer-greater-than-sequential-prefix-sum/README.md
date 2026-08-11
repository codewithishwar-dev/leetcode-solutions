# 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum

**Difficulty:** Easy  
**LeetCode:** https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/

---

## Problem Statement

You are given a 0-indexed integer array `nums`.

A prefix `nums[0...i]` is **sequential** if every element differs from the previous element by exactly `1`.

Return the **smallest integer** missing from the array that is **greater than or equal to the sum of the longest sequential prefix**.

---

## Example

### Example 1

**Input**

```text
nums = [1,2,3,2,5]
```

**Output**

```text
6
```

**Explanation**

Sequential prefix:

```text
[1,2,3]
```

Sum:

```text
1 + 2 + 3 = 6
```

Since `6` is not present in the array, the answer is `6`.

---

### Example 2

**Input**

```text
nums = [3,4,5,1,12,14,13]
```

**Output**

```text
15
```

**Explanation**

Sequential prefix:

```text
[3,4,5]
```

Sum:

```text
12
```

Numbers `12`, `13`, and `14` already exist, so the smallest missing integer is `15`.

---

# Approach

## Step 1: Find the Longest Sequential Prefix

Traverse from the beginning of the array.

Continue while

```text
nums[i] == nums[i - 1] + 1
```

Keep adding the elements to compute the prefix sum.

---

## Step 2: Store All Numbers

Insert every number into a **HashSet** for **O(1)** lookup.

---

## Step 3: Find the Smallest Missing Integer

Start from the prefix sum.

If the number exists in the set,

```text
sum++
```

Repeat until a missing number is found.

---

# Algorithm

1. Compute the sum of the longest sequential prefix.
2. Store all numbers in a HashSet.
3. Starting from the prefix sum, increment while the number exists.
4. Return the first missing number.

---

# Java Solution

```java
import java.util.HashSet;
import java.util.Set;

class Solution {

    public int missingInteger(int[] nums) {

        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        while (set.contains(sum)) {
            sum++;
        }

        return sum;
    }
}
```

---

# Python Solution

```python
class Solution:
    def missingInteger(self, nums):
        total = nums[0]

        for i in range(1, len(nums)):
            if nums[i] == nums[i - 1] + 1:
                total += nums[i]
            else:
                break

        s = set(nums)

        while total in s:
            total += 1

        return total
```

---

# Complexity Analysis

| Operation | Complexity |
|----------|------------|
| Find Sequential Prefix | O(n) |
| Build HashSet | O(n) |
| Search Missing Integer | O(n) |

### Time Complexity

```text
O(n)
```

### Space Complexity

```text
O(n)
```

---

# Key Takeaways

- Traverse until the sequential prefix breaks.
- Compute the prefix sum.
- Use a HashSet for constant-time lookups.
- Increment from the prefix sum until a missing integer is found.
- Overall complexity is **O(n)**.

---

**Tags:** Array, HashSet, Simulation
