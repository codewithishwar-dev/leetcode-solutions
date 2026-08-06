# 3345. Smallest Divisible Digit Product I

**Difficulty:** Easy

## Problem

Given two integers `n` and `t`, return the smallest number greater than or equal to `n` such that the product of its digits is divisible by `t`.

### Example 1

```text
Input: n = 10, t = 2
Output: 10
```

**Explanation:**

The digit product of `10` is `0`, which is divisible by `2`.

### Example 2

```text
Input: n = 15, t = 3
Output: 16
```

**Explanation:**

The digit product of `16` is `6`, which is divisible by `3`.

---

## Approach

Since the constraints are very small (`1 <= n <= 100` and `1 <= t <= 10`), a brute-force approach is sufficient.

1. Start checking from `n`.
2. Calculate the product of its digits.
3. If the product is divisible by `t`, return the current number.
4. Otherwise, increment the number and continue.

---

## Algorithm

1. Initialize the current number as `n`.
2. Compute the product of all digits.
3. Check if `product % t == 0`.
4. If true, return the current number.
5. Otherwise, increment the number and repeat.

---

## Java Solution

```java
class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            if (digitProduct(n) % t == 0) {
                return n;
            }
            n++;
        }
    }

    private int digitProduct(int num) {
        int product = 1;

        while (num > 0) {
            product *= (num % 10);
            num /= 10;
        }

        return product;
    }
}
```

---

## Dry Run

### Input

```text
n = 15
t = 3
```

### Execution

```text
15
→ Product = 1 × 5 = 5
→ 5 % 3 != 0

16
→ Product = 1 × 6 = 6
→ 6 % 3 == 0
```

### Output

```text
16
```

---

## Complexity Analysis

- **Time Complexity:** O(k × d)

  - `k` = numbers checked until the answer is found
  - `d` = number of digits (maximum 3 for the given constraints)

- **Space Complexity:** O(1)

---

## Key Takeaways

- Brute force is acceptable when constraints are small.
- Extracting helper methods (`digitProduct`) improves readability.
- Always check problem constraints before optimizing.
