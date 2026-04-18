public class Solution {

    public int mirrorDistance(int n) {
        int original = n;
        int rev = 0;

        while (n > 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }

        return Math.abs(original - rev);
    }

    // Optional: main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.mirrorDistance(25)); // 27
        System.out.println(sol.mirrorDistance(10)); // 9
        System.out.println(sol.mirrorDistance(7));  // 0
    }
}
