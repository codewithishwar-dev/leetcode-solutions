# 3370. Smallest Number With All Set Bits

## 🧩 Problem

Given a positive integer `n`, return the smallest number `x ≥ n` such that the binary representation of `x` contains only set bits.

A number with all set bits looks like:

* 1 → `1`
* 3 → `11`
* 7 → `111`
* 15 → `1111`

These numbers follow the pattern:

```
x = 2^k - 1
```

---

## 💡 Approach

We need to find the **smallest number of the form (2^k - 1)** that is **greater than or equal to `n`**.

### Steps:

1. Start with `k = 1`
2. Compute `(2^k - 1)`
3. Increase `k` until the value is ≥ `n`
4. Return that value

---

## 🚀 Code

```java
class Solution {
    public int smallestNumber(int n) {
        int k = 1;
        
        while ((1 << k) - 1 < n) {
            k++;
        }
        
        return (1 << k) - 1;
    }
}
```

---

## 🔍 Example

### Input

```
n = 10
```

### Output

```
15
```

### Explanation

* 7 → `111` ❌ (< 10)
* 15 → `1111` ✅

---

## ⏱ Complexity

* Time: `O(log n)`
* Space: `O(1)`

---

## 🧠 Key Insight

All valid numbers are of the form:

```
2^k - 1
```

So the task reduces to finding the smallest such number ≥ `n`.

---

## ✨ Author

**CodeWithIshwar 🚀** | Ishwar chandra Tiwari 
