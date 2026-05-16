/*
 * LeetCode Problem: 3074. Apple Redistribution into Boxes
 * Difficulty: Easy
 *
 * Approach:
 * - Calculate total apples.
 * - Sort box capacities in ascending order.
 * - Pick boxes from largest capacity to smallest.
 * - Count minimum boxes required until total capacity >= total apples.
 *
 * Time Complexity: O(m log m)
 * Space Complexity: O(1)
 */

import java.util.Arrays;

class Solution {

    public int minimumBoxes(int[] apple, int[] capacity) {

        int totalApples = 0;

        // Count total apples
        for (int a : apple) {
            totalApples += a;
        }

        // Sort capacities
        Arrays.sort(capacity);

        int currentCapacity = 0;
        int boxesUsed = 0;

        // Use largest boxes first
        for (int i = capacity.length - 1; i >= 0; i--) {

            currentCapacity += capacity[i];
            boxesUsed++;

            // Enough capacity collected
            if (currentCapacity >= totalApples) {
                return boxesUsed;
            }
        }

        return boxesUsed;
    }
}
