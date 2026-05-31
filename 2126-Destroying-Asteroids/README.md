# 2126. Destroying Asteroids

## Problem Statement

You are given an integer `mass`, representing the initial mass of a planet, and an integer array `asteroids` where `asteroids[i]` represents the mass of the `i-th` asteroid.

The planet can collide with the asteroids in any order.

* If the planet's mass is greater than or equal to the asteroid's mass, the asteroid is destroyed and its mass is added to the planet.
* Otherwise, the planet is destroyed.

Return `true` if all asteroids can be destroyed; otherwise, return `false`.

---

## Approach: Greedy + Sorting

### Intuition

To maximize the planet's growth, we should always destroy the smallest asteroid available first.

Every time the planet destroys an asteroid, its mass increases, making it easier to destroy larger asteroids later. Therefore, processing asteroids in ascending order is the optimal strategy.

---

## Algorithm

1. Sort the `asteroids` array in ascending order.
2. Store the planet's mass in a `long` variable.
3. Iterate through the sorted asteroids:

   * If `currentMass < asteroid`, return `false`.
   * Otherwise, add the asteroid's mass to `currentMass`.
4. If all asteroids are destroyed, return `true`.

---

## Dry Run

### Example 1

Input:

```text
mass = 10
asteroids = [3,9,19,5,21]
```

After sorting:

```text
[3,5,9,19,21]
```

| Planet Mass | Asteroid | New Mass |
| ----------- | -------- | -------- |
| 10          | 3        | 13       |
| 13          | 5        | 18       |
| 18          | 9        | 27       |
| 27          | 19       | 46       |
| 46          | 21       | 67       |

All asteroids are destroyed.

**Output:** `true`

---

### Example 2

Input:

```text
mass = 5
asteroids = [4,9,23,4]
```

After sorting:

```text
[4,4,9,23]
```

| Planet Mass | Asteroid | New Mass       |
| ----------- | -------- | -------------- |
| 5           | 4        | 9              |
| 9           | 4        | 13             |
| 13          | 9        | 22             |
| 22          | 23       | Cannot destroy |

**Output:** `false`

---

## Java Solution

```java
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long currentMass = mass;

        for (int asteroid : asteroids) {
            if (currentMass < asteroid) {
                return false;
            }

            currentMass += asteroid;
        }

        return true;
    }
}
```

---

## Correctness Proof

After sorting, every asteroid processed is the smallest remaining asteroid.

If the planet cannot destroy the smallest remaining asteroid, it cannot destroy any larger asteroid either. Therefore, returning `false` is correct.

If the planet can destroy the smallest asteroid, its mass increases, improving its ability to destroy future asteroids. Repeating this process ensures that whenever a valid ordering exists, the sorted ordering also succeeds.

Thus, the algorithm correctly determines whether all asteroids can be destroyed.

---

## Complexity Analysis

* **Time Complexity:** `O(n log n)`

  * Sorting the array takes `O(n log n)`.
  * Traversing the array takes `O(n)`.

* **Space Complexity:** `O(1)`

  * Ignoring the space used by the sorting algorithm.

---

## Key Takeaway

When you are allowed to choose the processing order and each successful operation increases your capability for future operations, sorting and greedily handling the smallest elements first is often the optimal strategy.

### Topics

* Array
* Sorting
* Greedy
