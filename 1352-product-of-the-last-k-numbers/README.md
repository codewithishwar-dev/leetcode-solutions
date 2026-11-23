
# 1352. Product of the Last K Numbers

**Difficulty:** Medium  
**Topics:** Design, Array, Prefix Product, Data Stream  
**Language:** Java

## Problem Statement

Design an algorithm that accepts a stream of integers and retrieves the product of the last `k` integers of the stream.

Implement the `ProductOfNumbers` class:

- `ProductOfNumbers()` – Initializes the object with an empty stream.
- `add(int num)` – Appends the integer `num` to the stream.
- `getProduct(int k)` – Returns the product of the last `k` numbers.

The product of any contiguous sequence is guaranteed to fit within a 32-bit integer.

## Approach: Prefix Product

Instead of multiplying the last `k` elements every time, we maintain a list of prefix products.

### Key Idea

Maintain a prefix product array where:

`prefixProducts[i]` represents the product of all elements since the most recent zero.

Initially:

```java
prefixProducts = [1];
```

### Operations

**1. add(num)**

- If `num == 0`, reset the prefix product list to `[1]`.
- Otherwise, multiply the latest prefix product by `num` and append the result.

**2. getProduct(k)**

- If `k >= prefixProducts.size()`, return `0` because the requested range contains a zero.
- Otherwise, calculate:

```java
prefixProducts.get(n - 1) /
prefixProducts.get(n - 1 - k);
```

This uses prefix product division to retrieve the required range in constant time.

## Java Solution

```java
import java.util.*;

class ProductOfNumbers {

    private List<Integer> prefixProducts;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1);
    }

    public void add(int num) {

        if (num == 0) {
            prefixProducts.clear();
            prefixProducts.add(1);
        } else {
            int lastProduct =
                prefixProducts.get(prefixProducts.size() - 1);

            prefixProducts.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {

        int n = prefixProducts.size();

        if (k >= n) {
            return 0;
        }

        return prefixProducts.get(n - 1) /
               prefixProducts.get(n - 1 - k);
    }
}
```

## Example

**Input:**

```text
["ProductOfNumbers", "add", "add", "add", "add", "add",
 "getProduct", "getProduct", "getProduct", "add", "getProduct"]

[[], [3], [0], [2], [5], [4], [2], [3], [4], [8], [2]]
```

**Output:**

```text
[null, null, null, null, null, null, 20, 40, 0, null, 32]
```

### Dry Run

| Operation | Prefix Products | Result |
|---|---|---|
| Initialize | [1] | - |
| add(3) | [1, 3] | - |
| add(0) | [1] | - |
| add(2) | [1, 2] | - |
| add(5) | [1, 2, 10] | - |
| add(4) | [1, 2, 10, 40] | - |
| getProduct(2) | [1, 2, 10, 40] | 20 |
| getProduct(3) | [1, 2, 10, 40] | 40 |
| getProduct(4) | [1, 2, 10, 40] | 0 |

## Complexity Analysis

Let `n` be the number of non-zero elements since the most recent zero.

| Operation | Time Complexity |
|---|---|
| Constructor | O(1) |
| add(num) | O(1) |
| getProduct(k) | O(1) |

**Space Complexity:** O(n)

## Key Learnings

- Prefix products can optimize repeated range-product queries.
- Division helps retrieve a subarray product in O(1).
- Zero requires special handling because division by zero is undefined.
- Resetting the prefix product list makes zero handling efficient.
- This approach achieves O(1) time for both `add()` and `getProduct()`.

## Pattern Recognition

**Prefix Product + Zero Reset**

This problem demonstrates how maintaining cumulative information can turn repeated calculations into constant-time queries.

---

**CodeWithIshwar | Ishwar Chandra Tiwari**

*Consistency. Patterns. Real Engineering Thinking.*
