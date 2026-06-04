# 3751. Total Waviness of Numbers in Range I

## Problem Summary

Given an inclusive range `[num1, num2]`, calculate the total waviness of all numbers in the range.

A digit is:

* A **Peak** if it is strictly greater than both adjacent digits.
* A **Valley** if it is strictly smaller than both adjacent digits.

The first and last digits can never be peaks or valleys.

---

## Approach

For each number in the range:

1. Convert the number to a string.
2. Traverse all internal digits (excluding the first and last).
3. Check whether the current digit forms:

   * a **Peak** (`curr > left && curr > right`)
   * a **Valley** (`curr < left && curr < right`)
4. Count all peaks and valleys for that number.
5. Add the count to the overall answer.

Since the maximum value is only `100000`, a direct simulation is efficient and straightforward.

---

## Algorithm

```text
for each number from num1 to num2:
    calculate waviness(number)
    add to answer

return answer
```

For each internal digit:

```text
if digit > left and digit > right:
    peak

if digit < left and digit < right:
    valley
```

---

## Complexity Analysis

* Time Complexity: `O((num2 - num1 + 1) × D)`
* Space Complexity: `O(D)`

Where:

* `D` = number of digits in a number
* `D ≤ 6` because `num2 ≤ 100000`

Thus, the solution effectively runs in linear time relative to the size of the range.

---

## Java Solution

```java
class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;

        for (int num = num1; num <= num2; num++) {
            total += waviness(num);
        }

        return total;
    }

    private int waviness(int num) {
        String s = String.valueOf(num);

        if (s.length() < 3) {
            return 0;
        }

        int count = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            char left = s.charAt(i - 1);
            char curr = s.charAt(i);
            char right = s.charAt(i + 1);

            if ((curr > left && curr > right) ||
                (curr < left && curr < right)) {
                count++;
            }
        }

        return count;
    }
}
```

---

## Key Takeaway

This problem is a good example of choosing the simplest solution that fits the constraints. Instead of overengineering with digit DP or advanced counting techniques, a direct scan of the range is sufficient and easy to maintain.
