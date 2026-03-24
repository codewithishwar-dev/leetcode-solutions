# 🚀 2906. Construct Product Matrix

📌 Added detailed README for Product Matrix using Prefix-Suffix technique

---

## 🧠 I almost overcomplicated this…

At first, I thought:

> “For every cell, multiply all other elements.”

It works…

But it’s painfully slow. ❌

---

## 💥 Then it clicked

This problem is not really 2D.

It’s just:

> **Product of Array Except Self — hidden inside a matrix**

---

## ⚠️ The trap

I almost used division:

👉 totalProduct / currentElement

But:

* Mod = **12345**
* Not a prime ❌
* Modular division fails ❌

So that idea is useless here.

---

## 🔑 The real trick

Instead of recomputing everything:

* Store product of elements **before**
* Store product of elements **after**

👉 Combine them.

---

## 💡 Final Formula

For every index:

> result = prefix × suffix

---

## ⚡ Complexity

* Time: **O(n × m)**
* Space: **O(n × m)**

---

## 🧵 CodeWithIshwar | Ishwar Chandra Tiwari 

> The smartest solutions don’t compute more…
> they **reuse more**.

---

## 🚀 Pattern Learned

* Prefix / Suffix
* Product Except Self
* Avoid Division under Mod

---

⭐ If this helped you think better, star the repo.
