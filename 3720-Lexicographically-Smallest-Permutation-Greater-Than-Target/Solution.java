class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            int x = target.charAt(i) - 'a';

            if (freq[x] == 0) {
                return buildAnswer(target, i, freq);
            }

            freq[x]--;
        }

        // target itself is a permutation of s.
        // Find the next lexicographical permutation.
        for (int i = n - 1; i >= 0; i--) {
            int current = target.charAt(i) - 'a';

            freq[current]++;

            for (int c = current + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    StringBuilder result = new StringBuilder();

                    result.append(target, 0, i);
                    result.append((char) ('a' + c));

                    freq[c]--;

                    appendSorted(result, freq);

                    return result.toString();
                }
            }
        }

        return "";
    }

    private String buildAnswer(String target, int failIndex, int[] freq) {
        int current = target.charAt(failIndex) - 'a';

        // Try increasing the current position.
        for (int c = current + 1; c < 26; c++) {
            if (freq[c] > 0) {
                StringBuilder result = new StringBuilder();

                result.append(target, 0, failIndex);
                result.append((char) ('a' + c));

                freq[c]--;

                appendSorted(result, freq);

                return result.toString();
            }
        }

        // Backtrack to find the rightmost position
        // that can be increased.
        for (int i = failIndex - 1; i >= 0; i--) {
            current = target.charAt(i) - 'a';

            freq[current]++;

            for (int c = current + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    StringBuilder result = new StringBuilder();

                    result.append(target, 0, i);
                    result.append((char) ('a' + c));

                    freq[c]--;

                    appendSorted(result, freq);

                    return result.toString();
                }
            }
        }

        return "";
    }

    private void appendSorted(StringBuilder result, int[] freq) {
        for (int c = 0; c < 26; c++) {
            while (freq[c] > 0) {
                result.append((char) ('a' + c));
                freq[c]--;
            }
        }
    }
}
