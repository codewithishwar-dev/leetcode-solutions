class Solution {

    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;
        int[] result = new int[n];

        // Tracks numbers already seen in A or B
        boolean[] seen = new boolean[n + 1];

        int commonCount = 0;

        for (int i = 0; i < n; i++) {

            // If A[i] was already seen in B,
            // it becomes a common element
            if (seen[A[i]]) {
                commonCount++;
            } else {
                seen[A[i]] = true;
            }

            // If B[i] was already seen in A,
            // it becomes a common element
            if (seen[B[i]]) {
                commonCount++;
            } else {
                seen[B[i]] = true;
            }

            result[i] = commonCount;
        }

        return result;
    }
}
