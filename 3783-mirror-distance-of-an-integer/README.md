# 3783. Mirror Distance of an Integer

## 🧩 Problem
You are given an integer `n`.

Define its mirror distance as:

mirror distance = |n - reverse(n)|

Where `reverse(n)` is the integer formed by reversing the digits of `n`.

---

## ✨ Examples

### Example 1
Input: n = 25  
Output: 27  
Explanation: reverse(25) = 52 → |25 - 52| = 27  

### Example 2
Input: n = 10  
Output: 9  
Explanation: reverse(10) = 1 → |10 - 1| = 9  

### Example 3
Input: n = 7  
Output: 0  
Explanation: reverse(7) = 7 → |7 - 7| = 0  

---

## 🚀 Approach

1. Reverse the number using modulo and division.
2. Compute absolute difference between original and reversed number.
3. Return result.

---

## 🧠 Complexity

- Time Complexity: O(d)  
- Space Complexity: O(1)  

(d = number of digits)

---

## 💻 Java Solution

```java
public int mirrorDistance(int n) {
    int original = n;
    int rev = 0;

    while (n > 0) {
        int digit = n % 10;
        rev = rev * 10 + digit;
        n /= 10;
    }

    return Math.abs(original - rev);
}
