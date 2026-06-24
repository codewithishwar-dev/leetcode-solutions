# 3700. Number of ZigZag Arrays II

## Problem Statement

Given three integers `n`, `l`, and `r`, count the number of ZigZag arrays of length `n`.

A ZigZag array satisfies:

* Every element belongs to the range `[l, r]`.
* No two adjacent elements are equal.
* No three consecutive elements are strictly increasing.
* No three consecutive elements are strictly decreasing.

Since the answer can be very large, return it modulo `10^9 + 7`.

---

## Example

### Example 1

```text
Input: n = 3, l = 4, r = 5
Output: 2
```

Valid arrays:

```text
[4,5,4]
[5,4,5]
```

---

### Example 2

```text
Input: n = 3, l = 1, r = 3
Output: 10
```

Valid arrays:

```text
[1,2,1]
[1,3,1]
[1,3,2]
[2,1,2]
[2,1,3]
[2,3,1]
[2,3,2]
[3,1,2]
[3,1,3]
[3,2,3]
```

---

# Key Observation

Consider the relation between adjacent elements.

For every pair:

```text
a[i] > a[i-1]  => UP
a[i] < a[i-1]  => DOWN
```

Since adjacent elements cannot be equal, every transition is either:

```text
UP (+)
or
DOWN (-)
```

Now consider the restriction:

```text
No three consecutive elements
can be strictly increasing.
```

This means:

```text
UP UP
```

is forbidden.

Similarly,

```text
DOWN DOWN
```

is forbidden.

Therefore, consecutive directions must alternate.

Valid direction patterns:

```text
+ - + - + ...
```

or

```text
- + - + - ...
```

Thus, a ZigZag array is completely characterized by alternating UP and DOWN moves.

---

# Dynamic Programming

Let:

```text
m = r - l + 1
```

represent the number of available values.

Renumber values:

```text
l      -> 1
l + 1  -> 2
...
r      -> m
```

Only relative ordering matters.

---

## DP State

Let:

```text
U(v)
```

be the number of valid arrays ending at value `v`
whose last movement was UP.

Similarly:

```text
D(v)
```

be the number of valid arrays ending at value `v`
whose last movement was DOWN.

---

## Transition

To end with an UP move at value `v`,
the previous value must be smaller than `v`,
and the previous move must be DOWN.

Therefore:

```text
U(v) = Σ D(u)
       for all u < v
```

Similarly:

```text
D(v) = Σ U(u)
       for all u > v
```

---

# Symmetry Optimization

Observe:

```text
D(v) = U(m + 1 - v)
```

The DOWN state is simply the mirror image of the UP state.

Therefore, we only need one state vector:

```text
F(v) = U(v)
```

Then:

```text
F_next(v)
=
Σ F(w)
for all w > m + 1 - v
```

---

# Matrix Representation

The above transition is linear.

Define matrix A:

```text
A[v][w] = 1
if v + w > m + 1

A[v][w] = 0
otherwise
```

Then:

```text
F(t + 1)
=
A × F(t)
```

After repeated transitions:

```text
F(n)
=
A^(n-2) × F(2)
```

This converts the DP into a matrix exponentiation problem.

---

# Initial Vector

For arrays of length 2:

To end at value `v`
with an UP move,

the first element can be any smaller value.

Hence:

```text
F(2)[v]
=
v - 1
```

Example:

```text
v = 1 -> 0
v = 2 -> 1
v = 3 -> 2
v = 4 -> 3
...
```

---

# Fast Matrix Exponentiation

The constraint:

```text
n ≤ 10^9
```

makes ordinary DP impossible.

Instead compute:

```text
A^(n-2)
```

using Binary Exponentiation.

Exponentiation complexity:

```text
O(m³ log n)
```

where:

```text
m ≤ 75
```

which is easily acceptable.

---

# Correctness Sketch

### Lemma 1

Every ZigZag array must alternate between UP and DOWN transitions.

Proof:

Two consecutive UP transitions create a strictly increasing triplet.

Two consecutive DOWN transitions create a strictly decreasing triplet.

Both are forbidden.

Therefore directions must alternate.

---

### Lemma 2

The DP transition counts exactly all valid extensions.

Proof:

To create an UP transition ending at `v`,
the previous value must be smaller than `v`
and the previous transition must be DOWN.

The transition enumerates exactly those states.

The DOWN case is symmetric.

---

### Lemma 3

The matrix A represents the DP transition.

Proof:

A[v][w] equals 1 exactly when
state `w` contributes to state `v`.

Thus matrix multiplication reproduces
the DP recurrence.

---

### Theorem

The algorithm returns the number of valid ZigZag arrays.

Proof:

By Lemma 1, every valid array corresponds to alternating directions.

By Lemma 2, the DP counts all valid states.

By Lemma 3, matrix exponentiation computes the DP for arbitrary length `n`.

Therefore the final sum equals the total number of ZigZag arrays.

---

# Complexity Analysis

Let:

```text
m = r - l + 1
```

with:

```text
m ≤ 75
```

### Time Complexity

```text
O(m³ log n)
```

### Space Complexity

```text
O(m²)
```

---

# Topics

* Dynamic Programming
* Matrix Exponentiation
* State Compression
* Mathematical DP
* Binary Exponentiation
* Hard LeetCode
