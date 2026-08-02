# 877. Stone Game

## Problem
Alice and Bob play a game with an even number of piles of stones.

On each turn:
- A player picks either the first or last pile.
- Both players play optimally.
- The player with more stones wins.

Return `true` if Alice wins.

---

## Approach

This problem has a mathematical observation.

- There are an even number of piles.
- Alice moves first.
- She can always choose either:
  - all even-indexed piles, or
  - all odd-indexed piles.
- One of these two groups must contain more stones because the total number of stones is odd.
- Alice chooses the richer parity and guarantees victory.

Therefore, Alice always wins.

---

## Java

```java
class Solution {
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
```

## Python

```python
class Solution:
    def stoneGame(self, piles):
        return True
```

---

## Complexity

| Complexity | Value |
|------------|-------|
| Time | O(1) |
| Space | O(1) |

---

## Key Insight

Alice always has a winning strategy because she can force herself to take either all even-indexed or all odd-indexed piles, whichever has the larger total number of stones.

---

**LeetCode:** 877. Stone Game  
**Difficulty:** Medium
