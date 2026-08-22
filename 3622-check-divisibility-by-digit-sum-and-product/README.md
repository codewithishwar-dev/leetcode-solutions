# 3622. Check Divisibility by Digit Sum and Product

> **LeetCode #3622** | **Difficulty:** Easy

## 📖 Problem Statement

Given a positive integer `n`, determine whether `n` is divisible by the sum of:

1. The **sum of its digits**.
2. The **product of its digits**.

Return `true` if `n` is divisible by the sum of these two values; otherwise, return `false`.

---

## 💡 Examples

### Example 1

**Input**

```text
n = 99
```

**Output**

```text
true
```

**Explanation**

- Digit Sum = `9 + 9 = 18`
- Digit Product = `9 × 9 = 81`
- Total = `18 + 81 = 99`

Since

```text
99 % 99 = 0
```

the answer is **true**.

---

### Example 2

**Input**

```text
n = 23
```

**Output**

```text
false
```

**Explanation**

- Digit Sum = `2 + 3 = 5`
- Digit Product = `2 × 3 = 6`
- Total = `5 + 6 = 11`

Since

```text
23 % 11 = 1
```

the answer is **false**.

---

## 🛠 Approach

The solution is straightforward.

1. Store the original number.
2. Traverse every digit of the number.
3. Calculate:
   - Digit Sum
   - Digit Product
4. Add these two values together.
5. Check whether the original number is divisible by the computed total.
6. Return the result.

---

## 🧠 Algorithm

1. Initialize:
   - `digitSum = 0`
   - `digitProduct = 1`
2. While `n > 0`
   - Extract the last digit using `n % 10`.
   - Add it to `digitSum`.
   - Multiply it into `digitProduct`.
   - Remove the last digit using `n /= 10`.
3. Compute

```text
total = digitSum + digitProduct
```

4. Return

```text
original % total == 0
```

---

## ✅ Correctness

For every digit in the number, the algorithm correctly computes:

- The sum of all digits.
- The product of all digits.

According to the problem statement, the required divisor is:

```text
digitSum + digitProduct
```

Finally, checking

```text
original % (digitSum + digitProduct)
```

determines whether the number is divisible by the required value.

Thus, the algorithm always produces the correct answer.

---

## 📈 Complexity Analysis

### Time Complexity

Let **d** be the number of digits.

```text
O(d)
```

Since

```text
n ≤ 10^6
```

the maximum number of digits is only **7**, making this effectively constant time.

---

### Space Complexity

```text
O(1)
```

Only a few integer variables are used.

---

## 🚶 Dry Run

### Input

```text
n = 99
```

### Step 1

Extract digit = 9

```text
digitSum = 9
digitProduct = 9
```

### Step 2

Extract digit = 9

```text
digitSum = 18
digitProduct = 81
```

### Final Calculation

```text
total = 18 + 81 = 99
```

```text
99 % 99 = 0
```

Answer:

```text
true
```

---

## 🧪 Edge Cases

### Case 1

```text
n = 1
```

- Sum = 1
- Product = 1
- Total = 2

```text
1 % 2 != 0
```

Answer:

```text
false
```

---

### Case 2

```text
n = 101
```

- Sum = 2
- Product = 0

```text
Total = 2
```

```text
101 % 2 != 0
```

Answer:

```text
false
```

---

### Case 3

Numbers containing zero.

Whenever a digit is `0`, the digit product becomes `0`, which is naturally handled by the algorithm without any special cases.

---

## 💻 Java Solution

```java
class Solution {
    public boolean checkDivisibility(int n) {
        int original = n;
        int digitSum = 0;
        int digitProduct = 1;

        while (n > 0) {
            int digit = n % 10;
            digitSum += digit;
            digitProduct *= digit;
            n /= 10;
        }

        return original % (digitSum + digitProduct) == 0;
    }
}
```

---

## 🎯 Key Takeaways

- Simple digit extraction using `% 10` and `/ 10`.
- Efficiently computes both digit sum and digit product in a single traversal.
- Constant extra space.
- Linear time with respect to the number of digits.
- Great beginner problem for practicing basic number manipulation.

---

## 🏷️ Tags

- Math
- Number Manipulation
- Simulation
- Easy

---

**Author:** CodeWithIshwar
