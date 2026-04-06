# 1437. Check If All 1's Are at Least Length K Places Away

## 🟢 Problem Statement

Given a binary array `nums` and an integer `k`, return `true` if all `1`s are at least `k` places away from each other, otherwise return `false`.

---

## 💡 Approach (Greedy + Single Pass)

We track the index of the last seen `1`.

* When we encounter a new `1`, we check:

  distance = current_index - last_index - 1

* If distance < k → return false

* Otherwise → continue

---

## 🚀 Algorithm

1. Initialize `lastIndex = -1`
2. Traverse the array:

   * If `nums[i] == 1`:

     * Check distance with last `1`
     * Update `lastIndex`
3. Return `true` if all conditions pass

---

## ⏱ Complexity

* Time: O(n)
* Space: O(1)

---

## ✅ Example

Input:
nums = [1,0,0,1,0,1], k = 2

Output:
false

---

## 🧠 Key Insight

Instead of counting zeros, we use index difference:
distance = i - lastIndex - 1

---

## 🏷 Tags

Array, Greedy, Sliding Window (Conceptual)

---

## 🔗 Related Problems

 605. Can Place Flowers
 485. Max Consecutive Ones

---
