# 1840. Maximum Building Height

## Problem

You want to build `n` buildings in a line.

Constraints:

* Building 1 must have height 0.
* Heights are non-negative integers.
* Adjacent buildings can differ by at most 1.
* Some buildings have maximum height restrictions.

Return the maximum possible height of the tallest building.

## Approach

### Step 1: Add Boundary Restrictions

* Add `[1,0]` since building 1 must have height 0.
* Add `[n,n-1]` because the maximum reachable height at building `n` is `n-1`.

### Step 2: Sort Restrictions

Sort all restrictions by building index.

### Step 3: Left-to-Right Pass

Ensure every restriction can be reached from the previous restriction:

`height[i] <= height[i-1] + distance`

### Step 4: Right-to-Left Pass

Ensure every restriction can be reached from the next restriction:

`height[i] <= height[i+1] + distance`

### Step 5: Find Maximum Peak

For two neighboring restrictions:

* Left building: `(x1, h1)`
* Right building: `(x2, h2)`

Maximum possible peak between them:

`(h1 + h2 + (x2 - x1)) / 2`

Take the maximum across all adjacent restriction pairs.

## Complexity Analysis

* Time Complexity: `O(k log k)`
* Space Complexity: `O(k)`

where `k = restrictions.length`.

## Key Learning

This problem combines:

* Greedy constraint propagation
* Interval optimization
* Peak height calculation between bounded points
