class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zeroIndex = 0;

        while (nums[zeroIndex] != 0) {
            zeroIndex++;
        }

        // Case 1: Sort using rotations only.
        boolean rotationPossible = true;

        for (int i = 0; i < n; i++) {
            if (nums[(zeroIndex + i) % n] != i) {
                rotationPossible = false;
                break;
            }
        }

        int ans = Integer.MAX_VALUE;

        if (rotationPossible) {
            // k rotations, or two reversals plus n-k rotations.
            ans = Math.min(zeroIndex, n - zeroIndex + 2);
        }

        // Case 2: Reverse first, then rotate.
        boolean reversePossible = true;

        for (int i = 0; i < n; i++) {
            int index = (n - 1 - i + n) % n;
            int rotatedIndex = (index + zeroIndex) % n;

            if (nums[rotatedIndex] != i) {
                reversePossible = false;
                break;
            }
        }

        /*
         * Instead of relying on the first zero's index for this case,
         * find the rotation needed after reversing the array.
         */
        int[] reversed = new int[n];

        for (int i = 0; i < n; i++) {
            reversed[i] = nums[n - 1 - i];
        }

        int reverseZeroIndex = 0;

        while (reversed[reverseZeroIndex] != 0) {
            reverseZeroIndex++;
        }

        boolean reversedRotationPossible = true;

        for (int i = 0; i < n; i++) {
            if (reversed[(reverseZeroIndex + i) % n] != i) {
                reversedRotationPossible = false;
                break;
            }
        }

        if (reversedRotationPossible) {
            ans = Math.min(
                ans,
                1 + Math.min(reverseZeroIndex, n - reverseZeroIndex)
            );
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
