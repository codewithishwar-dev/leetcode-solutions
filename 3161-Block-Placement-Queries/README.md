# 3161. Block Placement Queries

## Problem Link

https://leetcode.com/problems/block-placement-queries/

## Difficulty

Hard

## Approach

We need to process two types of operations:

1. Insert an obstacle at position `x`.
2. Determine whether a block of size `sz` can be placed completely within the range `[0, x]` without intersecting any obstacle.

A block can touch obstacles but cannot overlap them.

### Key Insight

For any query `[2, x, sz]`, the answer depends on the largest available free segment within `[0, x]`.

If the obstacles inside `[0, x]` are:

```text
o1 < o2 < o3 < ...
```

Then the free segments are:

```text
[0, o1]
[o1, o2]
[o2, o3]
...
[lastObstacle, x]
```

If the maximum free segment length is at least `sz`, then the block can be placed.

### Data Structures Used

* **TreeSet**

  * Maintains all obstacle positions in sorted order.
  * Supports finding previous and next obstacles in `O(log n)`.

* **Segment Tree**

  * Stores the gap immediately preceding each obstacle.
  * Supports:

    * Point updates in `O(log n)`
    * Range maximum queries in `O(log n)`

### Algorithm

#### Type 1 Query: Insert Obstacle

When inserting a new obstacle:

```text
prev ---- next
```

The existing gap:

```text
next - prev
```

is split into:

```text
x - prev
next - x
```

Update the segment tree accordingly.

#### Type 2 Query: Check Block Placement

Let:

```text
p = largest obstacle position <= x
```

The largest available segment inside `[0, x]` is:

```text
max(
    maximum gap among obstacles <= p,
    x - p
)
```

If this value is at least `sz`, return `true`; otherwise return `false`.

### Complexity Analysis

* Obstacle Insertion: `O(log M)`
* Query Processing: `O(log M)`

Where:

```text
M = 50000
```

Overall:

```text
O(Q log M)
```

which efficiently handles up to `150,000` queries.

### Tags

Segment Tree, TreeSet, Ordered Set, Offline Processing, Range Query
