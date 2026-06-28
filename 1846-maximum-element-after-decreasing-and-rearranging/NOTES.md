# Notes

## Key Insight

We can:

- Rearrange the array.
- Decrease any value.

Therefore, sorting gives the best order.

After sorting:

- First element must be `1`.
- Every next element should be as large as possible.
- Maximum allowed value is:

```
previous + 1
```

Hence,

```
current = min(current, previous + 1)
```

---

## Why Greedy Works

At every step, choosing the largest valid value leaves the most room for subsequent elements, ensuring the maximum possible final element.

---

## Complexity

- Sorting: O(n log n)
- Traversal: O(n)
- Space: O(1)

---

## Pattern

```
Sort
        ↓
Fix first element to 1
        ↓
Limit every next value to previous + 1
        ↓
Return last element
```

---

## Similar Problems

- 330. Patching Array
- 945. Minimum Increment to Make Array Unique
- 1827. Minimum Operations to Make the Array Increasing
- 1846. Maximum Element After Decreasing and Rearranging
