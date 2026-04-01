# 🤖 2751. Robot Collisions

## 📌 Problem Summary

You are given `n` robots, each with:

* A **unique position** on a number line
* A **health value**
* A **direction** of movement:

  * `'L'` → Left
  * `'R'` → Right

All robots move simultaneously at the same speed.

---

## ⚔️ Collision Rules

When two robots collide:

* The robot with **lower health is removed**
* The robot with **higher health survives** and its health is **reduced by 1**
* If both robots have **equal health**, both are removed

---

## 🎯 Objective

Return the **health values of surviving robots** in the **original input order**.

If no robots survive, return an empty array.

---

## 🧠 Approach

### 🔑 Key Insight

* Collisions only happen when:

  * A robot moving **Right (`R`)**
  * Meets a robot moving **Left (`L`)**

---

### ⚙️ Algorithm

1. **Combine robot data** into a structure:

   * `(position, health, direction, original_index)`

2. **Sort robots by position**

3. Use a **stack**:

   * Push robots moving `'R'`
   * When encountering `'L'`, resolve collisions

---

### ⚔️ Collision Handling

While stack is not empty and top robot is moving `'R'`:

* If `R.health > L.health`
  → R survives, `health--`, L dies

* If `R.health < L.health`
  → L survives, `health--`, remove R

* If equal
  → both die

---

4. **Store survivors** using original indices
5. Return result in input order

---

## 📊 Complexity Analysis

* **Time Complexity:** `O(n log n)` (sorting)
* **Space Complexity:** `O(n)` (stack + result storage)

---

## 🧪 Example

### Input

```
positions = [3,5,2,6]
healths  = [10,10,15,12]
directions = "RLRL"
```

### Output

```
[14]
```

---

## 💡 Key Takeaways

* Sorting ensures correct collision order
* Stack helps simulate real-time collisions
* Chain collisions must be handled carefully
* Always track original indices

---

## 🔁 Similar Problems

* Asteroid Collision (LeetCode 735)
* Car Fleet

---

## 🏷️ Tags

`Stack` `Simulation` `Sorting` `Hard`

---

## 👨‍💻 Author

**CodeWithIshwar 🚀**
