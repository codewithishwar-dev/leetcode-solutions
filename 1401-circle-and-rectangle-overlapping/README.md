# 1401. Circle and Rectangle Overlapping

[LeetCode Problem](https://leetcode.com/problems/circle-and-rectangle-overlapping/)

## Problem

You are given a circle represented by:

```text
(radius, xCenter, yCenter)
```

and an axis-aligned rectangle represented by:

```text
(x1, y1, x2, y2)
```

where `(x1, y1)` is the bottom-left corner and `(x2, y2)` is the top-right corner.

Return `true` if the circle and rectangle overlap at any point. Otherwise, return `false`.

## Examples

### Example 1

```text
Input:
radius = 1
xCenter = 0
yCenter = 0
x1 = 1
y1 = -1
x2 = 3
y2 = 1

Output:
true
```

### Example 2

```text
Input:
radius = 1
xCenter = 1
yCenter = 1
x1 = 1
y1 = -3
x2 = 2
y2 = -1

Output:
false
```

### Example 3

```text
Input:
radius = 1
xCenter = 0
yCenter = 0
x1 = -1
y1 = 0
x2 = 0
y2 = 1

Output:
true
```

## Approach

The key idea is to find the **closest point in the rectangle to the center of the circle**.

For the X coordinate, clamp `xCenter` to the rectangle's X range:

```java
int closestX = Math.max(x1, Math.min(xCenter, x2));
```

For the Y coordinate:

```java
int closestY = Math.max(y1, Math.min(yCenter, y2));
```

The point `(closestX, closestY)` is the closest point in the rectangle to the circle's center.

Now calculate the squared distance:

```text
distance² = (xCenter - closestX)² + (yCenter - closestY)²
```

The circle and rectangle overlap if:

```text
distance² <= radius²
```

We compare squared distances instead of calculating the actual distance using `sqrt()`, which keeps the solution simple and efficient.

## Algorithm

1. Find the closest X coordinate in the rectangle to `xCenter`.
2. Find the closest Y coordinate in the rectangle to `yCenter`.
3. Calculate the squared distance between the circle center and the closest rectangle point.
4. Compare the squared distance with `radius²`.
5. Return `true` if the squared distance is less than or equal to `radius²`.

## Java Implementation

```java
class Solution {

    public boolean checkOverlap(
            int radius,
            int xCenter,
            int yCenter,
            int x1,
            int y1,
            int x2,
            int y2) {

        // Find the closest point in the rectangle
        // to the circle's center.
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        // Calculate squared distance.
        int dx = xCenter - closestX;
        int dy = yCenter - closestY;

        return dx * dx + dy * dy <= radius * radius;
    }
}
```

## Complexity

* **Time Complexity:** `O(1)`
* **Space Complexity:** `O(1)`

## Key DSA Pattern

**Geometry + Coordinate Clamping + Closest Point**

### General Pattern

For a circle and axis-aligned rectangle:

```text
1. Clamp the circle center to the rectangle.
2. Get the closest point.
3. Calculate squared distance.
4. Compare with radius².
```

This avoids checking individual points or calculating the actual Euclidean distance.

## Tags

`Geometry` `Math` `Coordinate Geometry` `Clamping` `Distance`
