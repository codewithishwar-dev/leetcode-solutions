/*
 * LeetCode 3838. Weighted Word Mapping
 *
 * Approach:
 * 1. Calculate the total weight of each word.
 * 2. Compute totalWeight % 26.
 * 3. Map the result using reverse alphabetical order:
 *      0 -> z
 *      1 -> y
 *      ...
 *      25 -> a
 * 4. Append the mapped character to the result.
 *
 * Time Complexity: O(N × M)
 * Space Complexity: O(1)
 *
 * Author: Ishwar Chandra Tiwari
 * Code With Ishwar 🚀
 */

class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int totalWeight = 0;

            for (char ch : word.toCharArray()) {
                totalWeight += weights[ch - 'a'];
            }

            int mod = totalWeight % 26;
            result.append((char) ('z' - mod));
        }

        return result.toString();
    }
}
