# 486. Predict the Winner

**Difficulty:** Medium

## Problem

Two players take turns picking numbers from either end of an integer array.

- Player 1 starts first.
- Player 2 plays optimally.
- Each player adds the chosen number to their score.
- Return `true` if Player 1 can guarantee a win. A tie also counts as a win.

---

## Approach

Instead of calculating each player's final score, calculate the **maximum score difference** that the current player can achieve.

Let:

```
dp(left, right)
```

be the maximum score difference the current player can obtain from the subarray `nums[left...right]`.

The current player has two choices:

1. Pick the left number

```
nums[left] - dp(left + 1, right)
```

2. Pick the right number

```
nums[right] - dp(left, right - 1)
```

Therefore,

```
dp(left, right) =
max(
    nums[left] - dp(left + 1, right),
    nums[right] - dp(left, right - 1)
)
```

If the final difference is **greater than or equal to 0**, Player 1 can guarantee at least a tie.

---

## Algorithm

1. If only one number remains, return its value.
2. Recursively compute both choices.
3. Store computed results using memoization.
4. Return whether the final score difference is non-negative.

---

## Complexity

- **Time:** O(n²)
- **Space:** O(n²)

---

## Key Takeaway

For optimal two-player games, tracking the **score difference** is often simpler than tracking each player's score separately.

---

## Tags

- Dynamic Programming
- Memoization
- Game Theory
- Minimax
