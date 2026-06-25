class Solution {
    class FenwickTree {
        int[] bit;

        FenwickTree(int n) {
            bit = new int[n + 1];
        }

        void update(int index, int delta) {
            while (index < bit.length) {
                bit[index] += delta;
                index += index & -index;
            }
        }

        int query(int index) {
            int sum = 0;
            while (index > 0) {
                sum += bit[index];
                index -= index & -index;
            }
            return sum;
        }
    }

    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        int[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> rank = new HashMap<>();
        int id = 1;

        for (int value : sorted) {
            if (!rank.containsKey(value)) {
                rank.put(value, id++);
            }
        }

        FenwickTree bit = new FenwickTree(id);

        long ans = 0;

        for (int value : prefix) {
            int idx = rank.get(value);

            ans += bit.query(idx - 1);

            bit.update(idx, 1);
        }

        return (int) ans;
    }
}
