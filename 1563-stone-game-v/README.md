# 1563. Stone Game V

[LeetCode Problem](https://leetcode.com/problems/stone-game-v/)

**Difficulty:** Hard
**Language:** Java
**Topics:** Dynamic Programming, Interval DP, Prefix Sum, Game Theory, Array

---

## 1. Problem Statement

There are several stones arranged in a row.

Each stone has an associated integer value given by:

```text
stoneValue
```

Alice repeatedly performs the following operation:

1. Alice divides the current row of stones into two **non-empty** parts.
2. Bob calculates the sum of the values in both parts.
3. Bob removes the part with the **larger sum**.
4. Alice's score increases by the sum of the part that remains.
5. If both parts have equal sums, Alice can choose which part remains.
6. The game continues until only one stone remains.

Return the maximum score Alice can obtain.

---

## 2. Examples

### Example 1

```text
Input:
stoneValue = [6,2,3,4,5,5]

Output:
18
```

One optimal sequence is:

```text
[6,2,3] | [4,5,5]
   11   |    14
```

Since:

```text
11 < 14
```

Bob removes `[4,5,5]`.

Alice gets:

```text
11
```

Remaining:

```text
[6,2,3]
```

Alice splits again:

```text
[6] | [2,3]
 6  |   5
```

Since:

```text
5 < 6
```

Bob removes `[6]`.

Alice gets:

```text
5
```

Remaining:

```text
[2,3]
```

Final split:

```text
[2] | [3]
 2  |  3
```

Alice gets:

```text
2
```

Total:

```text
11 + 5 + 2 = 18
```

Therefore:

```text
Answer = 18
```

---

### Example 2

```text
Input:
stoneValue = [7,7,7,7,7,7,7]

Output:
28
```

---

### Example 3

```text
Input:
stoneValue = [4]

Output:
0
```

There is only one stone, so no split can be performed.

---

# 3. Important Observation

The most important observation is:

> After Alice makes a split, only one of the two resulting subarrays survives.

For example:

```text
[l ... k] | [k+1 ... r]
```

Depending on the two sums, either:

```text
[l ... k]
```

or:

```text
[k+1 ... r]
```

survives.

The game then continues recursively on that surviving interval.

This makes the problem a natural candidate for **Interval Dynamic Programming**.

---

# 4. Why Greedy Does Not Work

A tempting approach is:

> Always choose the split that gives Alice the largest immediate score.

This is not sufficient.

Alice's decision affects which stones remain for future rounds.

For example:

```text
Current score
     +
Future score
```

A split producing a slightly smaller immediate score may leave a much better subarray for future rounds.

Therefore, we need to consider both:

```text
Immediate score
```

and:

```text
Optimal future score
```

This is exactly what dynamic programming provides.

---

# 5. Interval DP Definition

Define:

```text
dp[l][r]
```

as:

> The maximum score Alice can obtain from the subarray `stoneValue[l...r]`.

For example:

```text
stoneValue = [6,2,3,4]
```

A state might be:

```text
dp[1][3]
```

which represents the maximum score Alice can obtain from:

```text
[2,3,4]
```

---

# 6. Base Case

If the interval contains only one stone:

```text
l == r
```

Alice cannot split it.

Therefore:

```text
dp[l][l] = 0
```

This is automatically handled because Java initializes the DP array with zeros.

---

# 7. Trying Every Split

For every interval:

```text
[l ... r]
```

we try every possible split position `k`.

The split becomes:

```text
[l ... k] | [k+1 ... r]
```

For example:

```text
[6,2,3,4,5]

Possible splits:

[6]       | [2,3,4,5]

[6,2]     | [3,4,5]

[6,2,3]   | [4,5]

[6,2,3,4] | [5]
```

Every possible split must be considered because Alice wants the globally optimal result.

---

# 8. Calculating the Two Sums

For a split at `k`:

```text
left  = stoneValue[l ... k]
right = stoneValue[k+1 ... r]
```

We need:

```text
leftSum
rightSum
```

Calculating these sums from scratch would take `O(n)` time for every split.

That would make the solution unnecessarily expensive.

We therefore use **Prefix Sum**.

---

# 9. Prefix Sum

Create:

```java
int[] prefix = new int[n + 1];
```

where:

```text
prefix[i]
```

contains the sum of:

```text
stoneValue[0 ... i-1]
```

Construction:

```java
for (int i = 0; i < n; i++) {
    prefix[i + 1] = prefix[i] + stoneValue[i];
}
```

For example:

```text
stoneValue:
[6, 2, 3, 4]

prefix:
[0, 6, 8, 11, 15]
```

---

# 10. Range Sum Formula

For the range:

```text
[l ... r]
```

the sum is:

```text
prefix[r + 1] - prefix[l]
```

Therefore, for a split at `k`:

### Left Sum

```java
int leftSum = prefix[k + 1] - prefix[l];
```

### Right Sum

```java
int rightSum = prefix[r + 1] - prefix[k + 1];
```

Both calculations take:

```text
O(1)
```

time.

---

# 11. DP Transition

There are exactly three cases.

---

## Case 1: Left Sum < Right Sum

Suppose:

```text
leftSum = 11
rightSum = 14
```

Bob removes the larger side:

```text
[4,5,5]
```

The left side survives:

```text
[6,2,3]
```

Alice receives:

```text
11
```

Then the game continues on the left interval.

Therefore:

```text
dp[l][r]
=
max(
    dp[l][r],
    leftSum + dp[l][k]
)
```

Java:

```java
dp[l][r] = Math.max(
    dp[l][r],
    leftSum + dp[l][k]
);
```

---

# 12. Case 2: Left Sum > Right Sum

Suppose:

```text
leftSum = 15
rightSum = 10
```

Bob removes the left side.

The right side survives.

Alice gets:

```text
10
```

The game continues on:

```text
[k+1 ... r]
```

Therefore:

```text
dp[l][r]
=
max(
    dp[l][r],
    rightSum + dp[k+1][r]
)
```

Java:

```java
dp[l][r] = Math.max(
    dp[l][r],
    rightSum + dp[k + 1][r]
);
```

---

# 13. Case 3: Left Sum == Right Sum

This is the interesting case.

Suppose:

```text
leftSum = 10
rightSum = 10
```

Bob allows Alice to choose which side to discard.

Therefore, Alice can choose whichever side produces the better future score.

The two possibilities are:

```text
10 + dp[l][k]
```

or:

```text
10 + dp[k+1][r]
```

Therefore:

```text
dp[l][r]
=
max(
    dp[l][r],
    leftSum + max(
        dp[l][k],
        dp[k+1][r]
    )
)
```

Java:

```java
dp[l][r] = Math.max(
    dp[l][r],
    leftSum + Math.max(
        dp[l][k],
        dp[k + 1][r]
    )
);
```

---

# 14. Complete Recurrence

The complete recurrence can be summarized as:

```text
if leftSum < rightSum:

    dp[l][r] =
        max(
            dp[l][r],
            leftSum + dp[l][k]
        )


if leftSum > rightSum:

    dp[l][r] =
        max(
            dp[l][r],
            rightSum + dp[k+1][r]
        )


if leftSum == rightSum:

    dp[l][r] =
        max(
            dp[l][r],
            leftSum + max(
                dp[l][k],
                dp[k+1][r]
            )
        )
```

---

# 15. Why Bottom-Up DP?

`dp[l][r]` depends on smaller intervals:

```text
dp[l][k]
```

and:

```text
dp[k+1][r]
```

Both of these intervals are strictly smaller than `[l...r]`.

Therefore, we process intervals from small to large.

```text
Length = 2
Length = 3
Length = 4
...
Length = n
```

This guarantees that all required smaller states have already been calculated.

---

# 16. DP Loop Structure

The structure is:

```java
for (int len = 2; len <= n; len++) {

    for (int l = 0; l + len <= n; l++) {

        int r = l + len - 1;

        for (int k = l; k < r; k++) {

            // Calculate leftSum
            // Calculate rightSum
            // Apply transition
        }
    }
}
```

There are three nested loops because we need to iterate over:

1. Interval length
2. Starting position
3. Split position

---

# 17. Complete Java Solution

```java
class Solution {

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        // Prefix sum
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        // dp[l][r] = maximum score Alice can obtain
        // from the subarray [l...r]
        int[][] dp = new int[n][n];

        // Process intervals from smaller to larger
        for (int len = 2; len <= n; len++) {

            for (int l = 0; l + len <= n; l++) {

                int r = l + len - 1;

                // Try every possible split
                for (int k = l; k < r; k++) {

                    int leftSum = prefix[k + 1] - prefix[l];
                    int rightSum = prefix[r + 1] - prefix[k + 1];

                    if (leftSum < rightSum) {

                        // Bob removes the right part.
                        // Alice keeps the left part.
                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + dp[l][k]
                        );

                    } else if (leftSum > rightSum) {

                        // Bob removes the left part.
                        // Alice keeps the right part.
                        dp[l][r] = Math.max(
                            dp[l][r],
                            rightSum + dp[k + 1][r]
                        );

                    } else {

                        // Equal sums:
                        // Alice can choose either side.
                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + Math.max(
                                dp[l][k],
                                dp[k + 1][r]
                            )
                        );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
```

---

# 18. Detailed Dry Run

Consider:

```text
stoneValue = [6,2,3]
```

We want:

```text
dp[0][2]
```

Possible splits:

```text
[6] | [2,3]
```

and:

```text
[6,2] | [3]
```

---

## Split 1

```text
[6] | [2,3]
```

Sums:

```text
leftSum  = 6
rightSum = 5
```

Since:

```text
6 > 5
```

Bob removes the left side.

Alice keeps:

```text
[2,3]
```

Alice receives:

```text
5
```

Future score:

```text
dp[1][2]
```

Therefore:

```text
candidate = 5 + dp[1][2]
```

---

## Split 2

```text
[6,2] | [3]
```

Sums:

```text
leftSum  = 8
rightSum = 3
```

Again:

```text
8 > 3
```

Bob removes the left side.

Alice receives:

```text
3
```

Future score:

```text
dp[2][2] = 0
```

Candidate:

```text
3 + 0 = 3
```

Therefore:

```text
dp[0][2]
=
max(
    5 + dp[1][2],
    3
)
```

The DP chooses the best possible result.

---

# 19. Visualizing the DP

For an array of length 4:

```text
[0, 1, 2, 3]
```

The DP table represents:

```text
       r
       0    1    2    3
    +-------------------
l 0 |  0   dp   dp   dp
  1 |       0   dp   dp
  2 |           0   dp
  3 |               0
```

Only the upper triangle is required.

For example:

```text
dp[0][3]
```

represents the entire array.

It depends on states such as:

```text
dp[0][0]
dp[1][3]

dp[0][1]
dp[2][3]

dp[0][2]
dp[3][3]
```

This is the characteristic structure of interval DP.

---

# 20. Why `dp[l][r]` Is Enough

We don't need to store:

* Alice's current score separately
* Bob's score
* The exact sequence of splits
* Which stones were previously removed

Why?

Because the only information needed for the future is:

```text
Which contiguous interval remains?
```

Once we know:

```text
[l, r]
```

the future game is independent of how we reached that interval.

This is the optimal-substructure property required for dynamic programming.

---

# 21. Optimal Substructure

Suppose the current surviving interval is:

```text
[l ... r]
```

and Alice chooses a split:

```text
[l ... k] | [k+1 ... r]
```

If the left side survives, the future game is completely represented by:

```text
dp[l][k]
```

If the right side survives, the future game is represented by:

```text
dp[k+1][r]
```

Therefore, an optimal solution can be constructed from optimal solutions to smaller subproblems.

---

# 22. Overlapping Subproblems

The same intervals can be reached through different splits.

For example:

```text
dp[2][5]
```

may be needed while evaluating several different larger intervals.

Without DP, we would repeatedly solve the same subproblem.

DP stores the result once and reuses it.

---

# 23. Complexity Analysis

Let:

```text
n = stoneValue.length
```

The constraints allow:

```text
1 <= n <= 500
```

### Prefix Sum

Building the prefix array:

```text
O(n)
```

### DP States

There are approximately:

```text
n² / 2
```

intervals.

Therefore:

```text
O(n²)
```

states.

### Split Evaluation

For every interval, we try up to:

```text
O(n)
```

split positions.

Therefore:

```text
O(n²) × O(n)
=
O(n³)
```

### Final Complexity

```text
Time Complexity:
O(n³)

Space Complexity:
O(n²)
```

For `n = 500`, this approach is suitable.

---

# 24. Why Prefix Sum Is Important

Without prefix sums:

```java
leftSum = calculateSum(l, k);
rightSum = calculateSum(k + 1, r);
```

Each sum calculation could take:

```text
O(n)
```

The DP already has three nested loops.

Adding another `O(n)` operation would make the approach:

```text
O(n⁴)
```

With prefix sums, each range sum is:

```text
O(1)
```

so the complete algorithm remains:

```text
O(n³)
```

---

# 25. Common Mistakes

## Mistake 1: Taking the Larger Sum

Alice does **not** receive the larger side.

Bob removes the larger side.

Alice receives the smaller side.

For example:

```text
10 | 15
```

Bob removes:

```text
15
```

Alice receives:

```text
10
```

---

## Mistake 2: Forgetting the Equal Case

When:

```text
leftSum == rightSum
```

Bob allows Alice to choose.

Therefore, we must consider both future possibilities:

```java
Math.max(dp[l][k], dp[k + 1][r])
```

---

## Mistake 3: Choosing Only the Best Immediate Score

The maximum immediate score is not necessarily the maximum final score.

Always include:

```text
current score + future optimal score
```

---

## Mistake 4: Incorrect DP Meaning

A common mistake is defining:

```text
dp[l][r]
```

as the score of the current split.

Instead, it should represent:

> The maximum total score Alice can obtain from the entire interval `[l...r]`.

This definition makes the recurrence much easier to derive.

---

## Mistake 5: Incorrect Interval Order

If using bottom-up DP, don't process arbitrary intervals.

Process:

```text
length = 2
length = 3
length = 4
...
```

because larger intervals depend on smaller intervals.

---

# 26. Interview Explanation

A concise interview explanation would be:

> "I would solve this using interval DP. I define `dp[l][r]` as the maximum score Alice can obtain from the subarray `l` through `r`. For every interval, I try every split position `k`. Using prefix sums, I calculate the left and right sums in O(1). If the left sum is smaller, Bob removes the right side, so the transition is `leftSum + dp[l][k]`. If the right sum is smaller, the transition is `rightSum + dp[k+1][r]`. If both sums are equal, Alice can choose either side, so I take the better of the two future states. Since there are O(n²) intervals and O(n) splits per interval, the time complexity is O(n³) and space complexity is O(n²)."

---

# 27. Pattern Recognition

When you see a problem containing:

```text
Array
+
Contiguous Range
+
Split into Two Parts
+
Choose One Part
+
Repeat Recursively
```

think about:

```text
Interval DP
```

Typical state:

```text
dp[l][r]
```

Typical transition:

```text
for k from l to r-1
```

Typical optimization:

```text
Prefix Sum
```

This pattern appears frequently in hard dynamic programming problems.

---

# 28. Alternative Recursive Formulation

The same problem can also be expressed using top-down memoization.

Conceptually:

```text
solve(l, r)
```

means:

> Maximum score Alice can obtain from `[l...r]`.

For every `k`:

```text
leftSum
rightSum
```

Then apply the same three transitions.

The difference is only the implementation style:

```text
Bottom-Up:
dp[l][r]

Top-Down:
solve(l, r) + memoization
```

The recurrence remains the same.

For this problem, bottom-up DP is a clean choice because the dependency order is straightforward.

---

# 29. Bottom-Up vs Top-Down

| Approach               |        Time | Space | Advantage                     |
| ---------------------- | ----------: | ----: | ----------------------------- |
| Bottom-Up DP           |       O(n³) | O(n²) | Clear interval ordering       |
| Top-Down + Memoization |       O(n³) | O(n²) | Natural recursive formulation |
| Brute Force            | Exponential | Large | Too slow                      |

For LeetCode, the bottom-up implementation is concise and avoids recursion overhead.

---

# 30. Edge Cases

### One stone

```text
[4]
```

No split is possible.

Answer:

```text
0
```

---

### Two stones

```text
[5, 3]
```

Only one split exists:

```text
[5] | [3]
```

Alice receives:

```text
3
```

Answer:

```text
3
```

---

### Equal values

```text
[7,7]
```

Both sides have equal sums.

Alice can choose either side.

Answer:

```text
7
```

---

### All equal values

```text
[7,7,7,7,7,7,7]
```

There are many equal-sum decisions.

The DP handles these choices automatically.

Answer:

```text
28
```

---

# 31. Key Takeaways

### 1. Recognize Interval DP

The problem repeatedly splits a contiguous interval.

```text
dp[l][r]
```

is the natural state.

### 2. Use Prefix Sum

Range sums need to be calculated many times.

Prefix sums reduce each range-sum query to:

```text
O(1)
```

### 3. Consider Future Score

The decision isn't based only on the current score.

We need:

```text
current score
+
optimal future score
```

### 4. Equal Sums Are Special

When:

```text
leftSum == rightSum
```

Alice has a choice.

Take the better future state.

### 5. Process Smaller Intervals First

Bottom-up interval DP requires:

```text
small interval
→
larger interval
→
complete array
```

---

# 32. Final Algorithm

```text
1. Build prefix sum array.

2. Create dp[n][n].

3. For interval length from 2 to n:
      a. For every starting position l:
            b. Calculate r.
            c. Try every split k.

4. Calculate:
      leftSum
      rightSum

5. Apply:
      leftSum < rightSum
          → leftSum + dp[l][k]

      leftSum > rightSum
          → rightSum + dp[k+1][r]

      leftSum == rightSum
          → leftSum + max(
                dp[l][k],
                dp[k+1][r]
            )

6. Return:
      dp[0][n-1]
```

---

# 33. Complexity Summary

```text
┌─────────────────────┐
│ Prefix Sum          │
│ O(n)                │
└──────────┬──────────┘
           ↓
┌─────────────────────┐
│ Interval DP         │
│ O(n²) states        │
└──────────┬──────────┘
           ↓
┌─────────────────────┐
│ Try Every Split     │
│ O(n) per state      │
└──────────┬──────────┘
           ↓
┌─────────────────────┐
│ Total: O(n³)        │
│ Space: O(n²)        │
└─────────────────────┘
```

---

## Related Concepts

* Dynamic Programming
* Interval Dynamic Programming
* Prefix Sum
* Range Sum Query
* Optimal Substructure
* Overlapping Subproblems
* Game Strategy
* Array Partitioning

---

## Tags

`#Java` `#LeetCode` `#DynamicProgramming` `#IntervalDP` `#PrefixSum` `#GameTheory` `#Hard`

---

## Solution File

```text
Solution.java
```

## Problem

**LeetCode 1563 — Stone Game V**

**Difficulty:** Hard

**Time Complexity:** `O(n³)`

**Space Complexity:** `O(n²)`
