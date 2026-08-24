# 1872. Stone Game VIII

[LeetCode Problem](https://leetcode.com/problems/stone-game-viii/)

**Difficulty:** Hard

**Topics:** Array, Dynamic Programming, Prefix Sum, Game Theory

---

## Problem

Alice and Bob take turns playing a game, with Alice starting first.

There are `n` stones arranged in a row.

On each player's turn, while there is more than one stone:

1. Choose an integer `x > 1`.
2. Remove the leftmost `x` stones.
3. Add the sum of the removed stones to the player's score.
4. Place a new stone with that sum on the left side of the row.

The game ends when only one stone remains.

Alice wants to maximize:

```text
Alice's score - Bob's score
