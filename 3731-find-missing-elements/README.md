# 3731. Find Missing Elements

## Problem
You are given an integer array `nums` consisting of unique integers.

Originally, `nums` contained every integer within a certain range. However, some integers might have gone missing from the array.

The smallest and largest integers of the original range are still present in `nums`.

Return a sorted list of all the missing integers in this range. If no integers are missing, return an empty list.

### Example

**Input**
```text
nums = [1,4,2,5]
```

**Output**
```text
[3]
```

---

## Approach

1. Find the minimum and maximum values in the array.
2. Store all elements in a `HashSet`.
3. Traverse from `min` to `max`.
4. If a number is not present in the set, add it to the answer list.
5. Return the list of missing numbers.

---

## Algorithm

```text
Find min and max
Insert all numbers into a HashSet

For every number from min to max:
    If number is not in HashSet:
        Add it to answer

Return answer
```

---

## Complexity Analysis

- **Time Complexity:** O(n + range)
- **Space Complexity:** O(n)

Where:
- `n` = number of elements in the array
- `range` = `max - min + 1`

---

## Java Solution

```java
import java.util.*;

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }
}
```

---

## Key Takeaways

- Use a `HashSet` for O(1) lookups.
- Traverse only between the minimum and maximum values.
- Simple and efficient solution.
