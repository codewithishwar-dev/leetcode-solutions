# 3418. Maximum Amount of Money Robot Can Earn

## 🟡 Medium

---

## 📌 Problem Statement

You are given an `m x n` grid where a robot starts at the top-left corner `(0, 0)` and wants to reach the bottom-right corner `(m - 1, n - 1)`.

The robot can only move:
- Right ➡️
- Down ⬇️

Each cell contains coins:

- `coins[i][j] >= 0` → gain coins
- `coins[i][j] < 0` → robber steals coins

The robot has a special power:
👉 It can **neutralize robbers in at most 2 cells**, avoiding loss.

Return the **maximum coins** the robot can collect.

---

## 💡 Approach

### 🔹 Key Idea

We use **Dynamic Programming with 3D state**:
dp[i][j][k]

Where:
- `i, j` → current position
- `k` → number of neutralizations used (0 to 2)

---

### 🔹 Transitions

From:
- Top `(i-1, j)`
- Left `(i, j-1)`

#### ✅ If cell is positive:
dp[i][j][k] = max(prev) + coins[i][j]

#### ❌ If cell is negative:
We have 2 choices:
1. Take loss
2. Neutralize (if k > 0)

<code>
dp[i][j][k] = max(
prev + coins[i][j],
prev[k-1]
)
</code>


## 🚀 Complexity

- **Time:** `O(m * n * 3)`
- **Space:** `O(m * n * 3)`

---

## 🧠 Key Insight

> Whenever a problem says **"at most K operations"**,  
> think **extra DP dimension**

---

## 📌 Example

### Input
coins = [[0,1,-1],[1,-2,3],[2,-3,4]]
### Output
8

---

## 🏷️ Tags

- Dynamic Programming
- Grid
- Optimization

## CodeWithIshwar | Ishwar Chandra Tiwari 
