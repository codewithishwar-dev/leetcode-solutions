# 1846. Maximum Element After Decreasing and Rearranging

**Difficulty:** Medium

## Problem Statement

Given an array of positive integers `arr`, you may perform the following operations any number of times:

- Rearrange the elements in any order.
- Decrease the value of any element to a smaller positive integer.

The final array must satisfy:

1. The first element is `1`.
2. The absolute difference between adjacent elements is at most `1`.

Return the **maximum possible value** of any element after performing these operations.

---

## Example

### Example 1

```text
Input: arr = [2,2,1,2,1]
Output: 2
```

### Example 2

```text
Input: arr = [100,1,1000]
Output: 3
```

### Example 3

```text
Input: arr = [1,2,3,4,5]
Output: 5
```

---

## Approach

Since rearrangement is allowed, the best strategy is to **sort the array**.

- Set the first element to `1`.
- Traverse from left to right.
- Each element can be at most `previous + 1`.
- Because we are only allowed to decrease values:

```
arr[i] = min(arr[i], arr[i - 1] + 1)
```

This greedy approach maximizes every element while maintaining the required conditions.

---

## Algorithm

1. Sort the array.
2. Set the first element to `1`.
3. Iterate through the array.
4. Replace each element with:

```
min(currentValue, previousValue + 1)
```

5. Return the last element.

---

## Dry Run

```
Input
[100,1,1000]

Sort
[1,100,1000]

First element = 1

100  -> min(100,2) = 2
1000 -> min(1000,3) = 3

Final array
[1,2,3]

Answer = 3
```

---

## Correctness

After sorting:

- The smallest value becomes `1`.
- Every next value is made as large as possible without violating

```
abs(arr[i]-arr[i-1]) <= 1
```

Therefore, the last element is the maximum achievable value.

---

## Complexity Analysis

- **Time:** O(n log n)
- **Space:** O(1) (excluding sorting implementation)

---

## Java Solution

```java
import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        arr[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }

        return arr[arr.length - 1];
    }
}
```

---

## Tags

- Array
- Sorting
- Greedy
