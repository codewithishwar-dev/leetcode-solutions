# Notes

## Key Observation

A subarray is valid if the `target` appears **strictly more than half** of the time.

Instead of counting frequencies directly, transform the array:

- `+1` if `nums[i] == target`
- `-1` otherwise

For any subarray,

```
sum = targetCount - otherCount
```

The target is the majority when

```
targetCount > otherCount
```

which is equivalent to

```
sum > 0
```

The problem is now reduced to:

> Count the number of subarrays whose transformed sum is positive.

---

## Prefix Sum

Let

```
prefix[i] = sum of transformed values from 0 to i-1
```

For a subarray `(l...r)`,

```
sum = prefix[r + 1] - prefix[l]
```

We need

```
prefix[r + 1] > prefix[l]
```

For every current prefix sum, count how many previous prefix sums are smaller.

---

## Why Coordinate Compression?

Prefix sums can be negative and may range from `-n` to `n`.

Fenwick Trees require indices starting from `1`, so compress all unique prefix sums into consecutive ranks.

Example:

```
Original : -2 -1 0 1 2
Compressed: 1  2 3 4 5
```

---

## Fenwick Tree

Maintain frequencies of previously seen prefix sums.

For each prefix:

1. Query the number of previous prefix sums smaller than the current one.
2. Add that count to the answer.
3. Insert the current prefix into the Fenwick Tree.

Each operation takes `O(log n)`.

---

## Complexity

| Operation | Complexity |
|----------|------------|
| Prefix Sum | O(n) |
| Coordinate Compression | O(n log n) |
| Fenwick Tree | O(n log n) |

Overall:

```
Time:  O(n log n)
Space: O(n)
```

---

## Pattern

This is a classic example of the following pattern:

```
Frequency Condition
        ↓
Convert to +1 / -1
        ↓
Prefix Sum
        ↓
Count Prefix Pairs
        ↓
Fenwick Tree + Coordinate Compression
```

---

## Similar Problems

- Count of Range Sum
- Count of Smaller Numbers After Self
- Reverse Pairs
- Number of Subarrays With More Ones Than Zeros
- Count Subarrays With Majority Element I

---

## Takeaways

- Convert frequency constraints into mathematical inequalities.
- Prefix sums transform subarray problems into prefix pair problems.
- Fenwick Trees efficiently count prefix relationships in `O(log n)`.
- Coordinate compression allows Fenwick Trees to work with arbitrary integer values.

---

## Interview Tip

When a problem asks about:

- majority
- more than half
- balance
- equal number
- more ones than zeros
- frequency difference

consider transforming values into `+1` and `-1`. This often reduces the problem to counting prefix sums with a Fenwick Tree or Segment Tree.
