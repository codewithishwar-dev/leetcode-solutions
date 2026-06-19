# 1732. Find the Highest Altitude

## Problem
A biker starts at altitude 0 and travels through a series of points. Given an array `gain`, where `gain[i]` represents the net altitude change between points `i` and `i + 1`, return the highest altitude reached.

## Approach
Use a running sum (prefix sum) to track the current altitude.
Keep updating the maximum altitude encountered during traversal.

## Algorithm
1. Initialize `altitude = 0` and `maxAltitude = 0`.
2. Iterate through the `gain` array.
3. Add each gain value to `altitude`.
4. Update `maxAltitude` if the current altitude is greater.
5. Return `maxAltitude`.

## Complexity
- Time Complexity: O(n)
- Space Complexity: O(1)

## Java Solution
```java
class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int maxAltitude = 0;

        for (int g : gain) {
            altitude += g;
            maxAltitude = Math.max(maxAltitude, altitude);
        }

        return maxAltitude;
    }
}
