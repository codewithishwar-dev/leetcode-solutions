import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i <= nums.length - k; i++) {
            Set<Integer> seen = new HashSet<>();

            for (int j = i; j < i + k; j++) {
                seen.add(nums[j]);
            }

            for (int value : seen) {
                count.put(value, count.getOrDefault(value, 0) + 1);
            }
        }

        int answer = -1;

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() == 1) {
                answer = Math.max(answer, entry.getKey());
            }
        }

        return answer;
    }
}
