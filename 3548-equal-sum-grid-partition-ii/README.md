# 3548. Equal Sum Grid Partition II

## 🧩 Problem Summary

Given an `m x n` grid of positive integers, determine whether you can make **one horizontal or vertical cut** such that:

* Both parts are non-empty
* The sums of both parts are:

  * Either equal
  * OR can be made equal by removing **at most one cell**
* After removing a cell, the section must remain **connected**

---

## 💡 Key Insight

At first glance, this looks like a brute-force + DFS problem.

But the real trick is:

> Reduce it to **prefix sums + checking if ONE value = diff exists safely**

---

## ⚡ Approach

### 1. Try all possible cuts

* Horizontal cuts
* Vertical cuts

---

### 2. For each cut

Compute:

```
sum1 = first section
sum2 = second section
```

---

### 3. If equal

```
return true
```

---

### 4. Else

```
diff = abs(sum1 - sum2)
```

Now check:

👉 Can we remove a cell with value = `diff` from the larger section?

---

## 🚨 Connectivity Constraint (Most Important)

This is the tricky part.

### Case 1: 2D section (rows > 1 AND cols > 1)

✅ Removing any cell keeps it connected

---

### Case 2: 1D section (single row OR single column)

❌ Removing a middle cell breaks connectivity

✅ Only **edge cells** are allowed

---

## ❌ Common Mistake

Checking only:

```
freq.contains(diff)
```

This fails because:

* The value might exist
* But removing it may **break connectivity**

---

## ✅ Correct Strategy

* If section is 2D → check existence
* If section is 1D → check only edges

---

## ⏱️ Complexity

* Time: `O(m * n * (m + n))`
* Space: `O(1)`

---

## 🚀 Key Learning

> Not every grid problem needs DFS.
> Sometimes **geometry + constraints** simplify everything.

---

## 🧠 Final Thought

This problem teaches:

* Think beyond brute force
* Translate constraints into structure (1D vs 2D)
* Always validate assumptions (connectivity here)

---

## 👨‍💻 Author

**CodeWithIshwar** | Ishwar Chandra Tiwari
