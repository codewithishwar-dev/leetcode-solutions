import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            maxFactor = Math.max(maxFactor, item[0]);
            minPrice = Math.min(minPrice, item[1]);
        }

        // Count how many items have each factor
        int[] freq = new int[maxFactor + 1];

        for (int[] item : items) {
            freq[item[0]]++;
        }

        // Compute the number of items whose factor is divisible by f
        for (int f = 1; f <= maxFactor; f++) {
            for (int multiple = f; multiple <= maxFactor; multiple += f) {
                // Accumulate counts of multiples
                if (multiple != f) {
                    freq[f] += freq[multiple];
                }
            }
        }

        // Sort items by price
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));

        long remaining = budget;
        long answer = 0;

        // First, buy copies that give 2 items each
        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            // No benefit over buying two cheapest single items
            if (price >= 2L * minPrice) {
                break;
            }

            int gain = freq[factor] - 1; // Exclude itself

            if (gain <= 0 || remaining < price) {
                continue;
            }

            long copies = Math.min(gain, remaining / price);

            answer += copies * 2;
            remaining -= copies * price;
        }

        // Use leftover budget to buy cheapest single-value items
        answer += remaining / minPrice;

        return (int) answer;
    }
}
