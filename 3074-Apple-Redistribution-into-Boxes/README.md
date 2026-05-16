# 3074. Apple Redistribution into Boxes

**Difficulty:** Easy  
**Language:** Java  
**Approach:** Greedy

---

## Problem Statement

You are given:
- an integer array `apple` where `apple[i]` represents the number of apples in the `i-th` pack.
- an integer array `capacity` where `capacity[i]` represents the capacity of the `i-th` box.

Return the minimum number of boxes required to redistribute all apples.

> Apples from the same pack can be distributed across multiple boxes.

---

## Example 1

```text
Input:
apple = [1,3,2]
capacity = [4,3,1,5,2]

Output:
2
```

### Explanation

Total apples = `1 + 3 + 2 = 6`

Using boxes with capacities:
- `5`
- `4`

Total capacity becomes `9`, which is enough.

So the minimum number of boxes required is `2`.

---

## Example 2

```text
Input:
apple = [5,5,5]
capacity = [2,4,2,7]

Output:
4
```

---

## Approach

This problem can be solved using a **Greedy Algorithm**.

### Steps
1. Count total apples.
2. Sort capacities in ascending order.
3. Pick boxes from largest to smallest.
4. Stop when collected capacity becomes enough.

---

## Java Solution

```java
import java.util.Arrays;

class Solution {

    public int minimumBoxes(int[] apple, int[] capacity) {

        int totalApples = 0;

        for (int a : apple) {
            totalApples += a;
        }

        Arrays.sort(capacity);

        int currentCapacity = 0;
        int boxesUsed = 0;

        for (int i = capacity.length - 1; i >= 0; i--) {

            currentCapacity += capacity[i];
            boxesUsed++;

            if (currentCapacity >= totalApples) {
                return boxesUsed;
            }
        }

        return boxesUsed;
    }
}
```

---

## Complexity Analysis

### Time Complexity
```text
O(m log m)
```

Sorting dominates the complexity.

### Space Complexity
```text
O(1)
```

---

## Tags

`Greedy` `Sorting` `Arrays`
