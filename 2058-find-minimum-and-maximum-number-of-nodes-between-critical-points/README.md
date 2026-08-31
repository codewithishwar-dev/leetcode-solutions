# 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points

## Problem

Given the head of a linked list, find the minimum and maximum distances between any two distinct critical points.

A node is a **critical point** if it is either:

* A **local maximum**: its value is strictly greater than both its previous and next nodes.
* A **local minimum**: its value is strictly smaller than both its previous and next nodes.

The first and last nodes cannot be critical points because they do not have both a previous and next node.

If there are fewer than two critical points, return `[-1, -1]`.

## Approach

Traverse the linked list once while keeping track of:

* `first` — position of the first critical point.
* `previous` — position of the most recent critical point.
* `minDistance` — minimum distance between consecutive critical points.

Whenever a critical point is found:

1. If it is the first critical point, store its position.
2. Otherwise, calculate the distance from the previous critical point.
3. Update the minimum distance.
4. Update the previous critical point.

After traversal:

```text
maxDistance = lastCriticalPoint - firstCriticalPoint
```

If fewer than two critical points exist, return:

```text
[-1, -1]
```

## Example

### Input

```text
[5, 3, 1, 2, 5, 1, 2]
```

Critical point positions:

```text
3, 5, 6
```

Minimum distance:

```text
min(5 - 3, 6 - 5) = 1
```

Maximum distance:

```text
6 - 3 = 3
```

### Output

```text
[1, 3]
```

## Complexity

* **Time:** `O(n)`
* **Space:** `O(1)`

The linked list is traversed only once and no additional collection is required.

## Key Insight

The maximum distance only depends on the **first and last critical points**.

The minimum distance only needs to be checked between **consecutive critical points**, because any non-consecutive pair will always have a distance at least as large as the distance between some consecutive pair.

## Languages

* Java
* Python

## LeetCode

[2058. Find the Minimum and Maximum Number of Nodes Between Critical Points](https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/)
