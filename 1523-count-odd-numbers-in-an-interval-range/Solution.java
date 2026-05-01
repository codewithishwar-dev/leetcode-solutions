/**
 * LeetCode 1523
 * Count Odd Numbers in an Interval Range
 *
 * Approach: Math (O(1))
 */
public class Solution {

    public int countOdds(int low, int high) {
        return (high + 1) / 2 - (low / 2);
    }

    // Optional: main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.countOdds(3, 7));   // Output: 3
        System.out.println(sol.countOdds(8, 10));  // Output: 1
    }
}
